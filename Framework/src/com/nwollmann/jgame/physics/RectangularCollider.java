package com.nwollmann.jgame.physics;

import java.awt.Dimension;

public class RectangularCollider extends Collider{
	protected boolean isSizeBound;
	protected Dimension size;
	
	public RectangularCollider(){
		super();
		isSizeBound = true;
		size = new Dimension();
	}
	
	public RectangularCollider(int x, int y, int width, int height){
		super(x, y, true);
		isSizeBound = true;
		size = new Dimension(width, height);
	}
	
	public RectangularCollider(int x, int y, Dimension size){
		super(x, y, true);
		isSizeBound = true;
		this.size = (Dimension)size.clone();
	}
	
	public RectangularCollider(int x, int y, int width, int height, boolean isBound){
		super(x, y, isBound);
		isSizeBound = isBound;
		size = new Dimension(width, height);
	}
	
	public RectangularCollider(int x, int y, Dimension size, boolean isBound){
		super(x, y, isBound);
		isSizeBound = isBound;
		this.size = (Dimension)size.clone();
	}
	
	public RectangularCollider(int x, int y, int width, int height, boolean isPositionBound, boolean isSizeBound){
		super(x, y, isPositionBound);
		this.isSizeBound = isSizeBound;
		size = new Dimension(width, height);
	}
	
	public RectangularCollider(int x, int y, Dimension size, boolean isPositionBound, boolean isSizeBound){
		super(x, y, isPositionBound);
		this.isSizeBound = isSizeBound;
		this.size = (Dimension)size.clone();
	}
	
	public boolean isSizeBound(){
		return isSizeBound;
	}
	
	public void setSizeBound(boolean isSizeBound){
		this.isSizeBound = isSizeBound;
	}
	
	public Dimension getSize(){
		return (Dimension)size.clone();
	}
	
	public void setSize(Dimension size){
		this.size = (Dimension)size.clone();
		isSizeBound = false;
	}
	
	public void setSize(Dimension size, boolean isSizeBound){
		this.size = (Dimension)size.clone();
		this.isSizeBound = isSizeBound;
	}
	
	public int getWidth(){
		return size.width;
	}
	
	public void setWidth(int width){
		size.width = width;
		isSizeBound = false;
	}
	
	public void setWidth(int width, boolean isBound){
		isSizeBound = isBound;
	}
	
	public int getHeight(){
		return size.height;
	}
	
	public void setHeight(int height){
		size.height = height;
		isSizeBound = false;
	}
	
	public void setHeight(int height, boolean isBound){
		size.height = height;
		isSizeBound = isBound;
	}
	
}
