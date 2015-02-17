package flappy;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;

import com.nwollmann.jgame.GameLabel;
import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.graphics.ColorRenderer;
public class Main {
	
	public static GameLabel label;
	
	public static void main(String[] args){
		GameManager gm = new GameManager();
		Player player = new Player();
		player.setVisible(true);
		player.setRenderer(new ColorRenderer(Color.red));
		player.setPosition(100, 100);
		player.setSize(new Dimension(50, 50));
		player.setCollidable(true);
		gm.registerObject(player);
		gm.registerInputListener(new InputListener());
		label = new GameLabel("Score: ");
		label.setPosition(0, 0);
		label.setSize(new Dimension(800, 100));
		label.setVisible(true);
		label.setLayer(1);
		gm.registerObject(label);
		ObstacleCreator obstacleCreator = new ObstacleCreator();
		obstacleCreator.execute();
		gm.registerEvent(obstacleCreator);
		gm.gameLoop();
		
		JOptionPane.showMessageDialog(null, "Your score was: " + (int) Player.getInstance().getScore());
	}
}
