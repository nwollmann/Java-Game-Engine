package com.nwollmann.jgame.physics;

import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.GameObject;

public class CollisionManager {
	
	public void collisionCheck(GameObject object1, GameObject object2){
		if(object1.getCollider() instanceof RectangularCollider){
			if(object2.getCollider() instanceof RectangularCollider) collisionCheck((RectangularCollider) object1.getCollider(), (RectangularCollider) object2.getCollider());
			else if(object2.getCollider() instanceof CircularCollider) collisionCheck((RectangularCollider) object1.getCollider(), (CircularCollider) object2.getCollider());
		}else if(object1.getCollider() instanceof CircularCollider){
			if(object2.getCollider() instanceof RectangularCollider) collisionCheck((RectangularCollider)object2.getCollider(), (CircularCollider)object1.getCollider());
			else if(object2.getCollider() instanceof CircularCollider) collisionCheck((CircularCollider) object1.getCollider(), (CircularCollider) object2.getCollider());	
		}
	}
	
	public void collisionCheck(RectangularCollider rect1, RectangularCollider rect2){
		if(GameManager.getInstance().isDebug()) System.out.println("Using default rectangular collision.");
		
	}
	
	public void collisionCheck(CircularCollider circle1, CircularCollider circle2){
		if(GameManager.getInstance().isDebug()) System.out.println("Using default circular collision.");
		if(circle1.getPosition().distance(circle2.getPosition()) <= circle1.getRadius() + circle2.getRadius()){
			circle1.getParent().onCollision(circle2.getParent());
			circle2.getParent().onCollision(circle1.getParent());
		}
	}
	
	public void collisionCheck(RectangularCollider rect, CircularCollider circle){
		if(GameManager.getInstance().isDebug()) System.out.println("Using default hybrid collision.");
		
	}
}
