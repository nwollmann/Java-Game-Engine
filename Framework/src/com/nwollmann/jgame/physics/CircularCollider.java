package com.nwollmann.jgame.physics;

public class CircularCollider extends Collider{
	protected int radius;
	protected boolean isSizeBound;
	
	public CircularCollider(){
		super();
		isSizeBound = true;
		radius = 0;
	}
	
	public CircularCollider(int x, int y, int radius){
		super(x, y);
		isSizeBound = true;
		this.radius = radius;
	}
	
	public CircularCollider(int x, int y, int radius, boolean isBound){
		super(x, y, isBound);
		this.radius = radius;
		isSizeBound = isBound;
	}
	
	public CircularCollider(int x, int y, int radius, boolean isPositionBound, boolean isSizeBound){
		super(x, y, isPositionBound);
		this.radius = radius;
		this.isSizeBound = isSizeBound;
	}
	
	public boolean isSizeBound(){
		return isSizeBound;
	}
	
	public void setSizebound(boolean isSizeBound){
		this.isSizeBound = isSizeBound;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public void setRadius(int radius){
		this.radius = radius;
		isSizeBound = false;
	}
	
	public void setRadius(int radius, boolean isSizeBound){
		this.radius = radius;
		this.isSizeBound = isSizeBound;
	}
	
}
