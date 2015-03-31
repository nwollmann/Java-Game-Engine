package com.nwollmann.jgame.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * Draws a rectangle of the set color at the game object's position. 
 * @author Nicholas Wollmann
 *
 */
public class ColorRenderer implements GameRenderer{
	
	private Color color;
	
	/**
	 * Constructs a new ColorRenderer which draws the given color.
	 */
	public ColorRenderer(Color color){
		this.color = color;
	}
	
	/**
	 * Sets the color of this renderer to the one provided.
	 */
	public void setColor(Color color){
		this.color = color;
	}
	
	/**
	 * Gets the color of this renderer.
	 */
	public Color getColor(){
		return color;
	}
	
	@Override
	public void render(int x, int y, Dimension size, Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(x, y, size.width, size.height);
	}

}
