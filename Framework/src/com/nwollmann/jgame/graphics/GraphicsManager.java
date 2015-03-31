package com.nwollmann.jgame.graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import com.nwollmann.jgame.util.GameObject;

/**
 * Manages everything related to the visual display of the game.
 * @author Nicholas Wollmann
 *
 */
public class GraphicsManager {
	private GameWindow window;
	private int x, y;
	
	/**
	 * Constructs a new graphics manager with a new game window.
	 */
	public GraphicsManager(){
		window = new GameWindow();
	}
	
	/**
	 * Gets the window of this graphics manager.
	 */
	public GameWindow getWindow(){
		return window;
	}
	
	/**
	 * Sets the size of the window used by this graphics manager.
	 */
	public void setSize(Dimension size){
		window.setSize(size);
	}
	
	/**
	 * Moves the center point of the camera by the given values.
	 */
	public void translate(int x, int y){
		this.x += x;
		this.y += y;
	}
	
	/**
	 * Renders all of the visible objects in the array list provided.
	 */
	public void renderObjects(ArrayList<GameObject> objects){
		BufferStrategy bufferStrategy = window.getBufferStrategy();
		Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
		graphics.clearRect(0, 0, window.getWidth(), window.getHeight());
		graphics.translate(x, y);
		for(GameObject object : objects)
			if(object.isVisible()) object.draw(graphics);
		
		bufferStrategy.show();
		graphics.dispose();
	}
}
