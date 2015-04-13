package flappyStarter;
import com.nwollmann.jgame.util.GameObject;
public class Obstacle extends GameObject{
	@Override
	public void update(){
		//will be called every update interval (default of 15ms)
	}
	
	@Override
	public void onCollision(GameObject obj){
		//put code that should run which this object hits another here
	}
}

