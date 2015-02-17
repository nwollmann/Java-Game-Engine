package com.nwollmann.jgame.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.nwollmann.jgame.GameManager;

public class ColorRenderer implements GameRenderer{
	
	private Color color;
	
	public ColorRenderer(Color color){
		this.color = color;
	}
	
	@Override
	public void render(int x, int y, Dimension size, Graphics2D graphics) {
		// TODO Auto-generated method stub
		//System.out.println("Called");
		//System.out.println("X: " + x + ", Y: " + y);
		//Graphics g = GameManager.getInstance().getGameWindow().getGamePanel().getGraphics();
		graphics.setColor(color);
		graphics.fillRect(x, y, size.width, size.height);
		
	}

}
