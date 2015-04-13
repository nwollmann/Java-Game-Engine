	package flappy;
import java.awt.Color;

import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.graphics.ColorRenderer;
import com.nwollmann.jgame.util.GameObject;
public class Obstacle extends GameObject{
	@Override
	public void update(){
		//move it left
		this.translateX(-5);
		
		if(this.getPosition().x + this.getSize().width == Player.getInstance().getPosition().x){
			Player.getInstance().adjustScore(0.5);
		}
		
		//iff offscreen delete it and give the player a point
		if(this.getPosition().x + this.getSize().width <= 0){
			//Player.getInstance().adjustScore(0.5);
			this.flagForDeletion();
		}
		
		
	}
	
	@Override
	public void onCollision(GameObject obj){
		if(obj instanceof Player){
			this.setRenderer(new ColorRenderer(Color.red));
			try{
				Thread.sleep(10);
			}catch(Exception e){
				
			}
			GameManager.getInstance().haltGame();
		}else{
			System.out.println("BAD COLLISION");
		}
	}
}

