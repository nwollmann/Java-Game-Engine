package com.nwollmann.jgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.nwollmann.jgame.graphics.ColorRenderer;

/**
 * This class acts as the primary controller for the game engine. 
 * @author Nicholas Wollmann
 *
 */
public class GameManager {

	private ArrayList<GameObject> objects;
	private ArrayList<AutomaticGameEvent> events;
	private ArrayList<GameInput> inputListeners;
	private boolean gameRunning;
	private static GameManager instance;
	private GameThread thread;
	private int frame;
	private int updateDelay;
	private int loopDelay;
	private GameWindow window;
	
	/**
	 * Creates a new GameManager with no game objects or automatic game events.
	 * It also sets the static 'instance' variable to the object created. This
	 * constructor does not start the game loop.
	 */
	public GameManager(){
		objects = new ArrayList<GameObject>();
		events = new ArrayList<AutomaticGameEvent>();
		inputListeners = new ArrayList<GameInput>();
		gameRunning = true;	
		instance = this;
		window = new GameWindow();
		updateDelay = 50;
		//runGame();
	}
	
	/**
	 * This returns the most recently created instance of Game Manager.
	 * @return Most recently created Game Manager object.
	 */
	public static GameManager getInstance(){
		return instance;
	}
	
	/**
	 * Starts the game loop.
	 */
	public void runGame(){
		thread = new GameThread();
		thread.start();
	}
	
	public void haltGame(){
		gameRunning = false;
	}
	
	public GameWindow getGameWindow(){
		return window;
	}
	
	public void registerKeyPressed(int keyID){
		for(GameInput listener : inputListeners){
			listener.keyPressed(keyID);
		}
	}
	
	public void gameLoop(){
		
		gameRunning = true;
		
		long previous = System.currentTimeMillis();
		long lag = 0;
		
		while(gameRunning){
			long current = System.currentTimeMillis();
			long elapsed = current - previous;
			lag += elapsed;
			
			//input processing
			
			//check for events
			for(AutomaticGameEvent event : events){
				if(event.getNextExecute() <= current){
					event.execute();
					event.setNextExecute(current + event.getDelay());
				}
			}
			
			//as many updates as necessary
			while(lag >= updateDelay){
				update();
				lag -= updateDelay;
			}
			
			BufferStrategy bs = window.getBufferStrategy();
			Graphics2D graphics = (Graphics2D) bs.getDrawGraphics();
			graphics.clearRect(0, 0, 800, 600);
			
			//window.createB
			for(GameObject object : objects){
				if(object.isVisible()) object.draw(graphics);
			}
			
			bs.show();
			graphics.dispose();
			
			//put in some kind of wait ?
			
			previous = current;
		}
	}
	
	/**
	 * A LOT OF WORK TO DO HERE.	
	 * Should end up being *only* update calls for all objects and checking
	 * for deletion flags
	 */
	private void update(){
		Iterator<GameObject> it = objects.iterator();
		while(it.hasNext()){
			GameObject object = it.next();
			object.update();
			if(object.isFlaggedForDeletion()) it.remove();
		}
	}
	
	/**
	 * Register a game object. This will result in the game object being updated on cycle, rendered if visible,
	 * and considered in collision checks if it is collidable.
	 * @param object The game object to register.
	 */
	public void registerObject(GameObject object){
		objects.add(object);
		objects.sort(new ObjectComparator());
	}
	
	public void registerEvent(AutomaticGameEvent event){
		event.setNextExecute(System.currentTimeMillis() + event.getDelay());
		events.add(event);
	}
	
	public void registerInputListener(GameInput listener){
		inputListeners.add(listener);
	}
	
	/**
	 * Checks for collision between the passed object and all other collidable game objects. The passed object must be
	 * collidable for this to work. If a collision is found, onCollide will be called for both objects.
	 * @param object1 The game object to check for, must be collidable. 
	 */
	public void collisionCheck(GameObject object1){
		if(!object1.collidable) return;
		Point pos1 = object1.getPosition();
		Dimension dim1 = object1.getSize();
		Rectangle rect1 = new Rectangle(pos1.x, pos1.y, dim1.width, dim1.height);
		Point pos2;
		Dimension dim2;
		Rectangle rect2;
		for(GameObject object2 : objects){
			if(object2 != object1 && object2.collidable){
				pos2 = object2.getPosition();
				dim2 = object2.getSize();
				rect2 = new Rectangle(pos2.x, pos2.y, dim2.width, dim2.height);
				if(rect1.intersects(rect2)){
					object1.onCollision(object2);
					object2.onCollision(object1);
				}
			}
		}
	}
	
	//a lot of work to be done here
	private class GameThread extends Thread{
		
		//more work to be done here
		public void run(){
			while(gameRunning){
				update();
				try{
					Thread.sleep(50);
				}catch(Exception e){}
			}
		}
		
	}
	
	private class ObjectComparator implements Comparator<GameObject>{
		public int compare(GameObject arg0, GameObject arg1) {
			return arg0.layer - arg1.layer;
		}
		
	}
	
}
