package Assignment3;


import com.nwollmann.jgame.physics.CircularCollider;
import com.nwollmann.jgame.physics.CollisionManager;
import com.nwollmann.jgame.physics.RectangularCollider;

public class MyCollisionManager extends CollisionManager{
	
	@Override
	public boolean collisionCheck(RectangularCollider rect1, RectangularCollider rect2){
		return false;
	}
	
	@Override
	public boolean collisionCheck(CircularCollider circle1, CircularCollider circle2){
		return false;
	}
	
	@Override
	public boolean collisionCheck(RectangularCollider rect, CircularCollider circle){
		return false;
	}
	
}
