package com.nwollmann.jgame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.nwollmann.jgame.graphics.GraphicsManager;
import com.nwollmann.jgame.input.GameInput;
import com.nwollmann.jgame.physics.CollisionManager;
import com.nwollmann.jgame.util.GameObject;


/**
 * This class acts as the primary controller for the game engine. 
 * @author Nicholas Wollmann
 *
 */
public class GameManager {

	private ArrayList<GameObject> objects;
	private ArrayList<AutomaticGameEvent> events;
	private ArrayList<GameInput> inputListeners; //move out to InputManager
	private boolean gameRunning;
	private static GameManager instance;
	private GameThread thread;
	private int updateDelay;
	private CollisionManager collisionManager;
	private GraphicsManager graphicsManager;
	
	private boolean debugMode;
	
	/**
	 * Creates a new GameManager with no game objects or automatic game events.
	 * It also sets the static 'instance' variable to the object created. This
	 * constructor does not start the game loop.
	 */
	private GameManager(){
		objects = new ArrayList<GameObject>();
		events = new ArrayList<AutomaticGameEvent>();
		inputListeners = new ArrayList<GameInput>();
		gameRunning = true;	
		instance = this;
		updateDelay = 50;
		collisionManager = new CollisionManager();
		graphicsManager = new GraphicsManager();
	}
	
	/**
	 * This returns the most recently created instance of Game Manager.
	 * @return Most recently created Game Manager object.
	 */
	public static GameManager getInstance(){
		if(instance == null) instance = new GameManager();
		return instance;
	}
	
	/**
	 * Sets whether the engine is in debug mode.
	 */
	public void setDebug(boolean debug){
		debugMode = debug;
		if(debug) System.out.println("Engine is now in debug mode");
		else System.out.println("Engine is no longer in debug mode");
	}
	
	/**
	 * Returns whether the engine is currently in debug mode.
	 */
	public boolean isDebug(){
		return debugMode;
	}
	
	/**
	 * Runs the game in a new thread.
	 */
	public void runGame(){
		thread = new GameThread();
		thread.start();
	}
	
	/**
	 * Stops the game after the current iteration of the game loop.
	 */
	public void haltGame(){
		gameRunning = false;
	}
	
	/**
	 * Report a key press that has been detected.
	 */
	public void registerKeyPressed(int keyID){
		for(GameInput listener : inputListeners){
			listener.keyPressed(keyID);
		}
	}
	
	/**
	 * The main loop of the game, which will continue running until after haltGame is called.
	 */
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
			
			//rendering
			graphicsManager.renderObjects(objects);
			
			previous = current;
		}
	}
	
	/**
	 * Sets the delay between calls to the update method of game objects.
	 */
	public void setUpdateDelay(int delay){
		updateDelay = delay;
	}
	
	/**
	 * Returns the delay between calls to the update method of game objects.
	 */
	public int getUpdateDelay(){
		return updateDelay;
	}
	
	/**
	 * A single update iteration for the game engine.
	 */
	private void update(){
		Iterator<GameObject> it = objects.iterator();
		while(it.hasNext()){
			GameObject object = it.next();
			object.update();
			if(object.isFlaggedForDeletion()) it.remove();
		}
		
		for(GameObject object : objects){
			if(object.isFlaggedForCollision()) this.collisionCheck(object);
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
	
	/**
	 * Registers an event to be called by the engine on delay.
	 */
	public void registerEvent(AutomaticGameEvent event){
		event.setNextExecute(System.currentTimeMillis() + event.getDelay());
		events.add(event);
	}
	
	/**
	 * Remove an event from the game engine.
	 */
	public void deregisterEvent(AutomaticGameEvent event){
		events.remove(event);
		
	}
	
	/**
	 * Register a Listener to be passed any input registered by the game engine.
	 */
	public void registerInputListener(GameInput listener){
		inputListeners.add(listener);
	}
	
	/**
	 * Checks for collision between the passed object and all other collidable game objects. The passed object must be
	 * collidable for this to work. If a collision is found, onCollide will be called for both objects.
	 * @param object1 The game object to check for, must be collidable. 
	 */
	public void collisionCheck(GameObject object1){
		if(!object1.isCollidable()) return;
		for(GameObject object2 : objects){
			if(object2 != object1 && object2.isCollidable())
				collisionManager.collisionCheck(object1, object2);
		}
	}
	
	/**
	 * Sets the collision manager to be used by the game engine.
	 */
	public void setCollisionManager(CollisionManager collisionManager){
		this.collisionManager = collisionManager;
	}
	
	/**
	 * Returns the collision manager used by the game engine.
	 */
	public CollisionManager getCollisionManager(){
		return collisionManager;
	}
	
	/**
	 * Sets the grpahics manager used by the game engine.
	 */
	public void setGraphicsManager(GraphicsManager graphicsManager){
		this.graphicsManager = graphicsManager;
	}
	
	/**
	 * Returns the graphics manager being used by the game engine.
	 */
	public GraphicsManager getGraphicsManager(){
		return graphicsManager;
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
			return arg0.getLayer() - arg1.getLayer();
		}
		
	}
	
}
