package com.nwollmann.jgame.test;

import java.awt.Dimension;

import com.nwollmann.jgame.GameManager;
import com.nwollmann.jgame.physics.CircularCollider;
import com.nwollmann.jgame.physics.CollisionManager;
import com.nwollmann.jgame.physics.RectangularCollider;
import com.nwollmann.jgame.util.GameObject;

/**
 * Provides various tests which can be run to ensure that the components of the game engine
 * are working as intended.
 * @author Nicholas Wollmann
 *
 */
public class GameTester {
	public static final int BASIC_COLLISION_MANAGER_TEST = 1;
	
	/**
	 * Runs the test corresponding to the provided test id.
	 */
	public static boolean test(int testType){
		GameManager.getInstance().setDebug(true);
		boolean result = false;
		switch(testType){
		case BASIC_COLLISION_MANAGER_TEST:
			result = collisionManagerTest();
			break;
		}
		GameManager.getInstance().setDebug(false);
		return result;
	}
	
	private static boolean collisionManagerTest(){
		CollisionManager manager = GameManager.getInstance().getCollisionManager();
		System.out.println("Beginning CollisionManager test.");
		int passed = 0;
		//testing rectangular collision checking
		GameObject object1 = new GameObject();
		object1.setCollider(new RectangularCollider());
		object1.setPosition(50, 50);
		object1.setSize(new Dimension(100, 100));
		GameObject object2 = new GameObject();
		object2.setCollider(new RectangularCollider());
		object2.setPosition(150, 150);
		object2.setSize(new Dimension(150, 150));
		if(manager.collisionCheck(object1, object2)){
			passed++;
			System.out.println("Rectangular collision: PASS");
		}else{
			System.out.println("Rectangular collision: FAIL");
		}
		object2.setSize(new Dimension(50, 50));
		if(manager.collisionCheck(object1, object2)){
			System.out.println("Rectangular non-collision: FAIL");
		}else{
			passed++;
			System.out.println("Rectangular non-collision: PASS");
		}
		//testing circular collision checking
		object1.setCollider(new CircularCollider());
		object2.setCollider(new CircularCollider());
		if(manager.collisionCheck(object1, object2)){
			passed++;
			System.out.println("Circular collision: PASS");
		}else{
			System.out.println("Circular collision: FAIL");
		}
		object2.setSize(new Dimension(25, 25));
		if(manager.collisionCheck(object1, object2)){
			System.out.println("Circular non-collision: FAIL");
		}else{
			passed++;
			System.out.println("Circular non-collision: PASS");
		}
		//testing hybrid collision checking
		//still needs to be written
		
		
		System.out.println("Tests passed: " + passed + " of 4");
		return false;
	}
}
