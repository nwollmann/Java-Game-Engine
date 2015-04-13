package flappyStarter;
import com.nwollmann.jgame.AutomaticGameEvent;
public class ObstacleCreator extends AutomaticGameEvent{
	@Override
	public int getDelay(){
		//set this to however many miliseconds you want between execute calls
		return 5000;
	}
	@Override
	public void execute(){
		//generate two Obstacles and register them with the game manager
	}
}
