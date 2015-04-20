package flappy;
import java.awt.Color;
import java.util.Random;

import com.nwollmann.jgame.AutomaticGameEvent;
import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.graphics.ColorRenderer;
public class ObstacleCreator extends AutomaticGameEvent{
	
	private ObstaclePair[] obstacles; 
	
	public ObstacleCreator(){
		//initialize the obstacles
		obstacles = new ObstaclePair[3];
		Random rand = new Random();
		int position = 800;
		for(int i = 0; i < 3; i++){
			int base = 150 + rand.nextInt(200);
			Obstacle top = new Obstacle();
			top.setPosition(position, 0);
			top.setWidth(75);
			top.setHeight(base);
			Obstacle bottom = new Obstacle();
			bottom.setPosition(position, base + 150);
			bottom.setWidth(75);
			bottom.setHeight(450 - base);
			
			GameManager.getInstance().registerObject(top);
			GameManager.getInstance().registerObject(bottom);
			
			obstacles[i] = new ObstaclePair(top, bottom);
			
			position += 500;
		}
	}
	
	@Override
	public int getDelay(){
		return 500;
	}
	@Override
	public void execute(){
		/*System.out.println("Obstacle Created");
		Random random = new Random();
		int base = 150 + random.nextInt(200);
		Obstacle obstacle1 = new Obstacle();
		obstacle1.setPosition(800, 0);
		obstacle1.setWidth(75);
		obstacle1.setHeight(base);
		obstacle1.setRenderer(new ColorRenderer(Color.green));
		//obstacle1.setRenderer(new ImageRenderer("src/assets/cards/queen_of_hearts.png"));
		obstacle1.setVisible(true);
		obstacle1.setCollidable(true);
		GameManager.getInstance().registerObject(obstacle1);
		Obstacle obstacle2 = new Obstacle();
		obstacle2.setPosition(800, base + 150);
		obstacle2.setWidth(75);
		obstacle2.setHeight(450 - base);
		obstacle2.setRenderer(new ColorRenderer(Color.green));
		//obstacle2.setRenderer(new ImageRenderer("src/assets/cards/queen_of_hearts.png"));
		obstacle2.setVisible(true);
		obstacle2.setCollidable(true);
		GameManager.getInstance().registerObject(obstacle2);*/
		
		int position = 0;
		for(ObstaclePair pair : obstacles){
			position = Math.max(position, pair.getTop().getPosition().x);
		}
		position += 500;
		Random random = new Random();
		for(ObstaclePair pair : obstacles){
			Obstacle top = pair.getTop();
			if(top.getPosition().x + top.getSize().width <= 0){
				Obstacle bottom = pair.getBottom();
				int base = 150 + random.nextInt(200);
				top.setHeight(base);
				top.setPosition(position, 0);
				bottom.setPosition(position, base + 150);
				bottom.setHeight(450 - base);
				position += 500;
			}
		}
		
	}
	
	
}
