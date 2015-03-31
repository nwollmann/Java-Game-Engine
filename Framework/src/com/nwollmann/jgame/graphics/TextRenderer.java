package com.nwollmann.jgame.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Renders the given string at the given location, drawing a box behind it.
 * @author Nicholas Wollmann
 *
 */
public class TextRenderer implements GameRenderer{
	
	/**
	 * Draws the text at the given location.
	 * @param x Left bound (minimum x)
	 * @param y Upper bound (minimum y)
	 * @param size Dimensions of the box
	 * @param string Text to display
	 * @param graphics The graphics object of the window
	 */
	public void renderText(int x, int y, Dimension size, String string, Graphics2D graphics){
		graphics.setColor(Color.GRAY);
		graphics.fillRect(x, y, size.width, size.height);
		graphics.setColor(Color.black);
		graphics.setFont(new Font("Arial", Font.BOLD, 40));
		graphics.drawString(string, x + 25, y + 75);
	}

	@Override
	public void render(int x, int y, Dimension size, Graphics2D graphics) {
		// TODO Auto-generated method stub
		
	}
	
}
