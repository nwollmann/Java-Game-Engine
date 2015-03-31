package com.nwollmann.jgame.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import com.nwollmann.jgame.GameManager;

/**
 * A window that the game renders into.
 * @author Nicholas Wollmann
 *
 */
public class GameWindow extends JFrame{
	
	private static final long serialVersionUID = 6551087290671448647L;
	private GamePanel panel;
	private KeyLis listener;
	
	/**
	 * Default constructor, sets up standard stuff.
	 */
	public GameWindow(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setIgnoreRepaint(true);
		listener = new KeyLis();
		this.addKeyListener(listener);
		createBufferStrategy(2);
		
		panel = new GamePanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setIgnoreRepaint(true);
		panel.setBackground(Color.WHITE);
		add(panel);
	}
	
	/**
	 * Returns the game panel of this window.
	 */
	public GamePanel getGamePanel(){
		return panel;
	}
	
	/**
	 * A key listener.
	 * @author Nicholas Wollmann
	 */
	private class KeyLis extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			//System.out.println(key);
			GameManager.getInstance().registerKeyPressed(key);
		}
	}
	
}
