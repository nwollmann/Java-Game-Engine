package com.nwollmann.jgame.exceptions;

/**
 * Exception thrown when an issue occurs within the collision system.
 * @author Nicholas Wollmann
 *
 */
public class CollisionException extends GameException{
	
	private static final long serialVersionUID = -89887972563202679L;

	public CollisionException(String message) {
		super(message);
	}

	
}
