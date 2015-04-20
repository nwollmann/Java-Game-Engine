package com.nwollmann.jgame.physics;

import java.awt.Dimension;
import java.awt.Rectangle;

/**
 * Used to detect collision for a rectangular object.
 * @author Nicholas Wollmann
 *
 */
public class RectangularCollider extends Collider{
	protected Dimension size;
	
	/**
	 * Constructs a new RectangularCollider
	 */
	public RectangularCollider(){
		super();
		sizeBound = true;
		size = new Dimension();
	}
	
	/**
	 * Constructs a new RectangularCollider with the given parameters.
	 */
	public RectangularCollider(int x, int y, int width, int height){
		super(x, y, true);
		sizeBound = true;
		size = new Dimension(width, height);
	}
	
	/**
	 * Constructs a new RectangularCollider with the given parameters.
	 */
	public RectangularCollider(int x, int y, Dimension size){
		super(x, y, true);
		sizeBound = true;
		this.size = (Dimension)size.clone();
	}
	
	/**
	 * Constructs a new RectangularCollider with the given parameters.
	 */
	public RectangularCollider(int x, int y, int width, int height, boolean isBound){
		super(x, y, isBound);
		sizeBound = isBound;
		size = new Dimension(width, height);
	}
	
	/**
	 * Constructs a new RectangularCollider with the given parameters.
	 */
	public RectangularCollider(int x, int y, Dimension size, boolean isBound){
		super(x, y, isBound);
		sizeBound = isBound;
		this.size = (Dimension)size.clone();
	}
	
	/**
	 * Constructs a new RectangularCollider with the given parameters.
	 */
	public RectangularCollider(int x, int y, int width, int height, boolean isPositionBound, boolean sizeBound){
		super(x, y, isPositionBound);
		this.sizeBound = sizeBound;
		size = new Dimension(width, height);
	}
	
	/**
	 * Constructs a new RectangularCollider with the given parameters.
	 */
	public RectangularCollider(int x, int y, Dimension size, boolean isPositionBound, boolean sizeBound){
		super(x, y, isPositionBound);
		this.sizeBound = sizeBound;
		this.size = (Dimension)size.clone();
	}
	
	/**
	 * Returns the size of this Collider.
	 */
	public Dimension getSize(){
		return (Dimension)size.clone();
	}
	
	/**
	 * Sets the size of this collider.
	 */
	public void setSize(Dimension size){
		this.size = (Dimension)size.clone();
		sizeBound = false;
	}
	
	/**
	 * Sets the size of this collider and whether it is size bound.
	 */
	public void setSize(Dimension size, boolean sizeBound){
		this.size = (Dimension)size.clone();
		this.sizeBound = sizeBound;
	}
	
	/**
	 * Returns the width of this collider.
	 */
	public int getWidth(){
		return size.width;
	}
	
	/**
	 * Sets the width of this collider.
	 */
	public void setWidth(int width){
		size.width = width;
		sizeBound = false;
	}
	
	/**
	 * Sets the width of this collider and whether it is size bound.
	 */
	public void setWidth(int width, boolean isBound){
		sizeBound = isBound;
	}
	
	/**
	 * Returns the height of this collider.
	 */
	public int getHeight(){
		return size.height;
	}
	
	/**
	 * Sets the height of this collider.
	 */
	public void setHeight(int height){
		size.height = height;
		sizeBound = false;
	}
	
	/**
	 * Sets the height of this collider and whether it is size bound.
	 */
	public void setHeight(int height, boolean isBound){
		size.height = height;
		sizeBound = isBound;
	}
	
	/**
	 * Returs the bounds of this collider.
	 */
	public Rectangle getBounds(){
		return new Rectangle(position.x, position.y, size.width, size.height);
	}
	
	@Override
	public void updateSize(Dimension size){
		this.size = size;
	}
	
	@Override
	public void updateSize(Dimension size, boolean bound){
		this.size = size;
		sizeBound = bound;
	}
	
	@Override
	public void updateSize(int width, int height){
		size = new Dimension(width, height);
		sizeBound = false;
	}
	
	@Override
	public void updateSize(int width, int height, boolean bound){
		size = new Dimension(width, height);
		sizeBound = bound;
	}
	
}
