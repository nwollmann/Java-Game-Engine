package flappy;
import java.awt.Color;
import java.util.Random;
import com.nwollmann.jgame.AutomaticGameEvent;
import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.graphics.ColorRenderer;
public class ObstacleCreator extends AutomaticGameEvent{
	@Override
	public int getDelay(){
		return 5000;
	}
	@Override
	public void execute(){
		System.out.println("Obstacle Created");
		Random random = new Random();
		int base = 150 + random.nextInt(200);
		Obstacle obstacle1 = new Obstacle();
		obstacle1.setPosition(800, 0);
		obstacle1.setWidth(75);
		obstacle1.setHeight(base);
		obstacle1.setRenderer(new ColorRenderer(Color.green));
		obstacle1.setVisible(true);
		obstacle1.setCollidable(true);
		GameManager.getInstance().registerObject(obstacle1);
		Obstacle obstacle2 = new Obstacle();
		obstacle2.setPosition(800, base + 200);
		obstacle2.setWidth(75);
		obstacle2.setHeight(400 - base);
		obstacle2.setRenderer(new ColorRenderer(Color.green));
		obstacle2.setVisible(true);
		obstacle2.setCollidable(true);
		GameManager.getInstance().registerObject(obstacle2);
	}
}
