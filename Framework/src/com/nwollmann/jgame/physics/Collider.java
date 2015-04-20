package com.nwollmann.jgame.physics;

import java.awt.Dimension;
import java.awt.Point;

import com.nwollmann.jgame.util.GameObject;

/**
 * Used to determine collision.
 * @author Nicholas Wollmann
 *
 */
public class Collider {
	protected boolean positionBound;
	protected boolean sizeBound;
	protected Point position;
	protected GameObject parent;
	
	/**
	 * Constructs a new Collider.
	 */
	public Collider(){
		positionBound = true;
		position = new Point(0, 0);
	}
	
	/**
	 * Constructs a new Collider at the given position.
	 */
	public Collider(int x, int y){
		positionBound = true;
		position = new Point(x, y);
	}
	
	/**
	 * Constructs a new Collider at the given position and sets whether it is position bound to its parent.
	 */
	public Collider(int x, int y, boolean positionBound){
		this.positionBound = positionBound;
		position = new Point(x, y);
	}
	
	/**
	 * Sets the GameObject which owns this collider.
	 */
	public void setParent(GameObject parent){
		this.parent = parent;
	}
	
	/**
	 * Gets the GameObject which owns this collider.
	 */
	public GameObject getParent(){
		return parent;
	}
	
	/**
	 * Returns whether this Collider is bound to the position of its parent.
	 */
	public boolean isPositionBound(){
		return positionBound;
	}
	
	/**
	 * Sets whether this Collider is bound to the position of its parent.
	 */
	public void setPositionBound(boolean positionBound){
		this.positionBound = positionBound;
	}
	
	/**
	 * Gets the position of this Collider.
	 */
	public Point getPosition(){
		return (Point)position.clone();
	}
	
	/**
	 * Returns the x position of this Collider.
	 */
	public int getPositionX(){
		return position.x;
	}
	
	/**
	 * Returns the y position of this Collider.
	 */
	public int getPositionY(){
		return position.y;
	}
	
	/**
	 * Sets the position of this Collider and sets it to be no longer position bound.
	 */
	public void setPosition(Point position){
		positionBound = false;
		this.position = position;
	}
	
	/**
	 * Sets the position of this Collider and sets it to be no longer position bound.
	 */
	public void setPosition(int x, int y){
		positionBound = false;
		position.x = x;
		position.y = y;
	}
	
	/**
	 * Sets the x position of this Collider and sets it to be no longer position bound.
	 */
	public void setPositionX(int x){
		positionBound = false;
		position.x = x;
	}
	
	/**
	 * Sets the y position of this collider and sets it to be no longer position bound.
	 */
	public void setPositionY(int y){
		positionBound = false;
		position.y = y;
	}
	
	/**
	 * Sets the position of this Collider and whether it is position bound.
	 */
	public void setPosition(Point position, boolean positionBound){
		this.positionBound = positionBound;
		this.position = position;
	}
	
	/**
	 * Sets the position of this Collider and whether it is position bound.
	 */
	public void setPosition(int x, int y, boolean positionBound){
		this.positionBound = positionBound;
		position.x = x;
		position.y = y;
	}
	
	/**
	 * Sets the x position of this Collider and whether it is position bound.
	 */
	public void setPositionX(int x, boolean positionBound){
		this.positionBound = positionBound;
		position.x = x;
	}
	
	/**
	 * Sets the y position of this Collider and whether it is position bound.
	 */
	public void setPositionY(int y, boolean positionBound){
		this.positionBound = positionBound;
		position.y = y;
	}
	
	/**
	 * Returns whether this collider is size bound.
	 */
	public boolean isSizeBound(){
		return sizeBound;
	}
	
	/**
	 * Sets whether this Collider is size bound.
	 */
	public void setSizeBound(boolean sizeBound){
		this.sizeBound = sizeBound;
	}
	
	/**
	 * Updates the size of this Collider and sets it to no longer be size bound.
	 */
	public void updateSize(Dimension size){
		sizeBound = false;
	}
	
	/**
	 * Sets the size of this collider and whether it is size bound.
	 */
	public void updateSize(Dimension size, boolean bound){
		sizeBound = bound;
	}
	
	/**
	 * Sets the size of this Collider and sets it to no longer be size bound.
	 */
	public void updateSize(int width, int height){
		sizeBound = false;
	}
	
	/**
	 * Sets the size of this Collider and whether it is size bound.
	 */
	public void updateSize(int width, int height, boolean bound){
		sizeBound = bound;
	}
}
