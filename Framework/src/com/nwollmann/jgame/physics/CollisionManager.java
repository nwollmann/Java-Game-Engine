package com.nwollmann.jgame.physics;

import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.exceptions.CollisionException;
import com.nwollmann.jgame.util.GameObject;

public class CollisionManager {
	
	public boolean collisionCheck(GameObject object1, GameObject object2) throws CollisionException{
		boolean collisionDetected;
		if(object1.getCollider() instanceof RectangularCollider){
			if(object2.getCollider() instanceof RectangularCollider) collisionDetected = collisionCheck((RectangularCollider) object1.getCollider(), (RectangularCollider) object2.getCollider());
			else if(object2.getCollider() instanceof CircularCollider) collisionDetected = collisionCheck((RectangularCollider) object1.getCollider(), (CircularCollider) object2.getCollider());
			else throw new CollisionException(object2 + " of an unknown collider type.");
		}else if(object1.getCollider() instanceof CircularCollider){
			if(object2.getCollider() instanceof RectangularCollider) collisionDetected = collisionCheck((RectangularCollider)object2.getCollider(), (CircularCollider)object1.getCollider());
			else if(object2.getCollider() instanceof CircularCollider) collisionDetected = collisionCheck((CircularCollider) object1.getCollider(), (CircularCollider) object2.getCollider());	
			else throw new CollisionException(object2 + " of an unknown collider type.");
		}else{
			throw new CollisionException(object1 + " of an unknown collider type.");
		}
		
		if(collisionDetected){
			object1.onCollision(object2);
			object2.onCollision(object1);
		}
		
		return collisionDetected;
	}
	
	public boolean collisionCheck(RectangularCollider rect1, RectangularCollider rect2){
		if(GameManager.getInstance().isDebug()) System.out.println("Using default rectangular collision.");
		if(rect1.getBounds().intersects(rect2.getBounds())){
			return true;
		}
		return false;
	}
	
	public boolean collisionCheck(CircularCollider circle1, CircularCollider circle2){
		if(GameManager.getInstance().isDebug()) System.out.println("Using default circular collision.");
		if(circle1.getPosition().distance(circle2.getPosition()) <= circle1.getRadius() + circle2.getRadius()){
			circle1.getParent().onCollision(circle2.getParent());
			circle2.getParent().onCollision(circle1.getParent());
			return true;
		}else{
			return false;
		}
	}
	
	public boolean collisionCheck(RectangularCollider rect, CircularCollider circle){
		if(GameManager.getInstance().isDebug()) System.out.println("Using default hybrid collision.");
		int rectX = (rect.getPositionX() >= circle.getPositionX()) ? rect.getPositionX() - rect.getWidth()/2 : rect.getPositionX() + rect.getWidth()/2;
		int rectY = (rect.getPositionY() >= circle.getPositionY()) ? rect.getPositionY() - rect.getHeight()/2 : rect.getPositionY() + rect.getHeight()/2;
		//if(circle.getPosition().distance(new Point(rectX, rectY)) <= circle.radius)
		return false;
	}
}
