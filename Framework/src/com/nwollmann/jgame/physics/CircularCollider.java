package com.nwollmann.jgame.physics;

import java.awt.Dimension;

/**
 * Used to detect collision for a circular object.
 * @author Nicholas Wollmann
 *
 */
public class CircularCollider extends Collider{
	protected int radius;
	
	/**
	 * Constructs a new CircularCollider.
	 */
	public CircularCollider(){
		super();
		sizeBound = true;
		radius = 0;
	}
	
	/**
	 * Constructs a new CircularCollider with the given parameters.
	 */
	public CircularCollider(int x, int y, int radius){
		super(x, y);
		sizeBound = true;
		this.radius = radius;
	}
	
	/**
	 * Constructs a new CircularCollider with the given parameters.
	 */
	public CircularCollider(int x, int y, int radius, boolean isBound){
		super(x, y, isBound);
		this.radius = radius;
		sizeBound = isBound;
	}
	
	/**
	 * Constructs a new CircularCollider with the given parameters.
	 */
	public CircularCollider(int x, int y, int radius, boolean isPositionBound, boolean sizeBound){
		super(x, y, isPositionBound);
		this.radius = radius;
		this.sizeBound = sizeBound;
	}
	
	/**
	 * Returns the radius of this CircularCollider.
	 */
	public int getRadius(){
		return radius;
	}
	
	/**
	 * Sets the radius of this CircularCollider.
	 */
	public void setRadius(int radius){
		this.radius = radius;
		sizeBound = false;
	}
	
	/**
	 * Sets the radius of the CircularCollider while also setting whether it is bound to the size of its parent.
	 */
	public void setRadius(int radius, boolean sizeBound){
		this.radius = radius;
		this.sizeBound = sizeBound;
	}
	
	@Override
	public void updateSize(Dimension size){
		radius = Math.max(size.width, size.height);
	}
	
	@Override
	public void updateSize(Dimension size, boolean bound){
		radius = Math.max(size.width, size.height);
		sizeBound = bound;
	}
	
	@Override
	public void updateSize(int width, int height){
		radius = Math.max(width, height);
		sizeBound = false;
	}
	
	@Override
	public void updateSize(int width, int height, boolean bound){
		radius = Math.max(width, height);
		sizeBound = bound;
	}

}
