package com.nwollmann.jgame.input;

/**
 * This interface is used to register listeners to the GameManager.
 * @author Nicholas Wollmann
 *
 */
public interface GameInput {
	/**
	 * This listening method will be called if a button press is registered.
	 * @param keyID ID of the key.
	 */
	public void keyPressed(int keyID);
}
