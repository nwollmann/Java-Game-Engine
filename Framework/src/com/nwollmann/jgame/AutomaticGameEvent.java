package com.nwollmann.jgame;

/**
 * An event which can be registered with the GameManager to be called repeatedly in the future.
 * 
 * @author Nicholas Wollmann
 *
 */
public class AutomaticGameEvent {
	
	private long nextExecute;
	
	/**
	 * Sets the system time when this event will next be invoked. Intended for use by the GameManager class.
	 * @param nextExecute Milliseconds of next execute
	 */
	public final void setNextExecute(long nextExecute){
		this.nextExecute = nextExecute;
	}
	
	/**
	 * Gets the system time when this event will next be invoked. Intended for use by the GameManager class.
	 * @return Milliseconds of next execute
	 */
	public final long getNextExecute(){
		return nextExecute;
	}

	/**
	 * Returns the minimum delay between executions of this event in milliseconds. Intended for use by the GameManager class.
	 * Any child classes should override this method.
	 * @return Delay in milliseconds between executes
	 */
	public int getDelay(){
		//return 1000;
		return 500;
	}
	
	/**
	 * Executes the event. Intended for use by the GameManager class.
	 * Child classes should override this method.
	 */
	public void execute(){
		//System.out.println("Executed");
	}
	
}
