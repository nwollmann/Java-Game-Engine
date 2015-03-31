package blackjack;

import java.awt.Dimension;

import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.graphics.CardRenderer;
import com.nwollmann.jgame.util.GameObject;

public class Main {
	
	public static void main(String[] args){
		GameManager manager = GameManager.getInstance();
		Table table = new Table();
		//table.setRenderer(new ColorRenderer(Color.black));
		table.setPosition(0, 0);
		table.setSize(new Dimension(800, 600));
		table.setVisible(true);
		
		GameObject card = new GameObject();
		card.setPosition(250, 50);
		card.setSize(new Dimension(100, 150));
		card.setRenderer(new CardRenderer(5, "clubs", false));
		card.setVisible(true);
		card.setLayer(1);
		GameObject card2 = new GameObject();
		card2.setPosition(300, 50);
		card2.setSize(new Dimension(100, 150));
		card2.setRenderer(new CardRenderer(12, "clubs", true));
		card2.setVisible(true);
		card2.setLayer(1);
		GameObject card3 = new GameObject();
		card3.setPosition(250, 400);
		card3.setSize(new Dimension(100, 150));
		card3.setRenderer(new CardRenderer(1, "hearts", false));
		card3.setVisible(true);
		card3.setLayer(1);
		GameObject card4 = new GameObject();
		card4.setPosition(300, 400);
		card4.setSize(new Dimension(100, 150));
		card4.setRenderer(new CardRenderer(10, "spades", false));
		card4.setVisible(true);
		card4.setLayer(1);
		GameObject card5 = new GameObject();
		card5.setPosition(500, 225);
		card5.setSize(new Dimension(100, 150));
		card5.setRenderer(new CardRenderer(5, "clubs", true));
		card5.setVisible(true);
		card5.setLayer(1);
		manager.registerObject(card5);
		manager.registerObject(card3);
		manager.registerObject(card4);
		manager.registerObject(card);
		manager.registerObject(card2);
		manager.registerObject(table);
		manager.setUpdateDelay(25);
		manager.gameLoop();
		System.out.println("Game Stopped");
	}
	
}
