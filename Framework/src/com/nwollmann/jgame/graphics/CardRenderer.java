package com.nwollmann.jgame.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class CardRenderer extends ImageRenderer{
	
	boolean showBack;

	public CardRenderer(String card) {
		super("src/assets/cards/" + card);
	}
	
	public CardRenderer(int value, String suit){
		String card = "";
		switch(value){
		case 1:
			card = "ace";
			break;
		case 11:
			card = "jack";
			break;
		case 12:
			card = "queen";
			break;
		case 13:
			card = "king";
			break;
		default:
			card = value + "";
		}
		card += "_of_" + suit.toLowerCase();
		System.out.println(card);
		this.loadImage("src/assets/cards/" + card + ".png");
	}
	
	public CardRenderer(int value, String suit, boolean showBack){
		this.showBack = showBack;
		String card = "";
		switch(value){
		case 1:
			card = "ace";
			break;
		case 11:
			card = "jack";
			break;
		case 12:
			card = "queen";
			break;
		case 13:
			card = "king";
			break;
		default:
			card = value + "";
		}
		card += "_of_" + suit.toLowerCase();
		System.out.println(card);
		this.loadImage("src/assets/cards/" + card + ".png");
	}
	
	@Override
	public void render(int x, int y, Dimension size, Graphics2D graphics){
		graphics.setColor(Color.black);
		graphics.fillRect(x, y, size.width, size.height);
		if(showBack){
			graphics.setColor(Color.red);
			graphics.fillRect(x + 1, y + 1, size.width - 2, size.height - 2);
		}else{
			super.render(x + 1, y + 1, new Dimension(size.width - 2, size.height - 2), graphics);
		}
	}
	
}
