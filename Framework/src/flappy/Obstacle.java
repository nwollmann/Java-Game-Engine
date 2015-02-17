package flappy;
import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.GameObject;
public class Obstacle extends GameObject{
	@Override
	public void update(){
		//move it left
		this.translateX(-5);
		
		//iff offscreen delete it and give the player a point
		if(this.getPosition().x + this.getSize().width <= 0){
			Player.getInstance().adjustScore(0.5);
			this.flagForDeletion();
		}
		
		
	}
	
	@Override
	public void onCollision(GameObject obj){
		if(obj instanceof Player){
			GameManager.getInstance().haltGame();
		}else{
			System.out.println("BAD COLLISION");
		}
	}
}

