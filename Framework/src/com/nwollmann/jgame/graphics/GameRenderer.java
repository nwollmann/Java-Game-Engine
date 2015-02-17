package com.nwollmann.jgame.graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * The parent interface of all renderers in the JGame framework.
 * @author Nicholas Wollmann
 *
 */
public interface GameRenderer{
	
	public void render(int x, int y, Dimension size, Graphics2D graphics);
	
}
