package com.nwollmann.jgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.nwollmann.jgame.graphics.GamePanel;

public class GameWindow extends JFrame{
	private GamePanel panel;
	private KeyLis listener;
	
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
	
	public GamePanel getGamePanel(){
		return panel;
	}
	
	private class KeyLis extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			//System.out.println(key);
			GameManager.getInstance().registerKeyPressed(key);
		}
	}
	
}
