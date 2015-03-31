package com.nwollmann.jgame.graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * The parent interface of all renderers in the JGame framework.
 * @author Nicholas Wollmann
 *
 */
public interface GameRenderer{
	
	/**
	 * Draws the game object at the given position.
	 * @param x The left hand (minimum) value
	 * @param y The upper (minimum) value
	 * @param size The dimensions of the object
	 * @param graphics The window's graphics object
	 */
	public void render(int x, int y, Dimension size, Graphics2D graphics);
	
}
