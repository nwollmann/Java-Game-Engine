
package com.nwollmann.jgame;

import java.awt.Graphics2D;

import com.nwollmann.jgame.graphics.TextRenderer;

/**
 * 
 * @author Nicholas Wollmann
 *
 */
public class GameLabel extends GameObject{
	private String text;
	private TextRenderer renderer;
	
	public GameLabel(){
		text = "";
		renderer = new TextRenderer();
	}
	
	public GameLabel(String initial){
		text = initial;
		renderer = new TextRenderer();
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	@Override
	public void draw(Graphics2D graphics){
		renderer.renderText(this.getPosition().x, this.getPosition().y, this.getSize(), text, graphics);
	}
	
}
