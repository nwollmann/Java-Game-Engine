package flappyStarter;
import com.nwollmann.jgame.GameManager;
public class Main {
	
	public static void main(String[] args){
		GameManager gm = GameManager.getInstance();
		Player player = new Player();
		//setup the player here
		gm.registerObject(player);
		gm.registerInputListener(new InputListener());
		//setup your label and register it to the GameManager
		ObstacleCreator obstacleCreator = new ObstacleCreator();
		obstacleCreator.execute(); //if this was not here then it would not execute until a full delay after the game starts running
		gm.registerEvent(obstacleCreator);
		gm.gameLoop();
		//code to run after the game ennds
	}
}
