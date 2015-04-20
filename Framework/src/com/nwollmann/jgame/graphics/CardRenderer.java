package com.nwollmann.jgame.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 * Renders a card of the given value and suit using stock images found in the engine assets.
 * @author Nicholas Wollmann
 *
 */
public class CardRenderer extends ImageRenderer{
	
	boolean showBack;

	/**
	 * Constructs a CardRenderer for the given card.
	 */
	public CardRenderer(String card) {
		super("src/assets/cards/" + card);
	}
	
	/**
	 * Constructs a CardRenderer for the given value and suit.
	 */
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
	
	/**
	 * Constructs a CardRenderer for the given value and suit then sets whether it is showing the back or face of the card.
	 */
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
		graphics.fillRoundRect(x, y, size.width, size.height, 8, 8);
		if(showBack){
			graphics.setColor(Color.red);
			graphics.fillRect(x + 1, y + 1, size.width - 2, size.height - 2);
		}else{
			super.render(x + 1, y + 1, new Dimension(size.width - 2, size.height - 2), graphics);
		}
	}
	
}
