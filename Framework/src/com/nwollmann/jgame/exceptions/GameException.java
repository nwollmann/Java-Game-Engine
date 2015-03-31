package com.nwollmann.jgame.exceptions;

/**
 * An exception thrown when an issue occurs within the game engine.
 * @author Nicholas Wollmann
 *
 */
public class GameException extends RuntimeException{
	
	private static final long serialVersionUID = 7273805110314484922L;

	public GameException(String message){
		super(message); 
	}
	
}
