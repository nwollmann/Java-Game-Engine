package com.nwollmann.jgame.physics;

import java.awt.Dimension;

public class CircularCollider extends Collider{
	protected int radius;
	
	public CircularCollider(){
		super();
		sizeBound = true;
		radius = 0;
	}
	
	public CircularCollider(int x, int y, int radius){
		super(x, y);
		sizeBound = true;
		this.radius = radius;
	}
	
	public CircularCollider(int x, int y, int radius, boolean isBound){
		super(x, y, isBound);
		this.radius = radius;
		sizeBound = isBound;
	}
	
	public CircularCollider(int x, int y, int radius, boolean isPositionBound, boolean sizeBound){
		super(x, y, isPositionBound);
		this.radius = radius;
		this.sizeBound = sizeBound;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public void setRadius(int radius){
		this.radius = radius;
		sizeBound = false;
	}
	
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
