package com.nwollmann.jgame.physics;

import java.awt.Dimension;
import java.awt.Rectangle;

public class RectangularCollider extends Collider{
	protected Dimension size;
	
	public RectangularCollider(){
		super();
		sizeBound = true;
		size = new Dimension();
	}
	
	public RectangularCollider(int x, int y, int width, int height){
		super(x, y, true);
		sizeBound = true;
		size = new Dimension(width, height);
	}
	
	public RectangularCollider(int x, int y, Dimension size){
		super(x, y, true);
		sizeBound = true;
		this.size = (Dimension)size.clone();
	}
	
	public RectangularCollider(int x, int y, int width, int height, boolean isBound){
		super(x, y, isBound);
		sizeBound = isBound;
		size = new Dimension(width, height);
	}
	
	public RectangularCollider(int x, int y, Dimension size, boolean isBound){
		super(x, y, isBound);
		sizeBound = isBound;
		this.size = (Dimension)size.clone();
	}
	
	public RectangularCollider(int x, int y, int width, int height, boolean isPositionBound, boolean sizeBound){
		super(x, y, isPositionBound);
		this.sizeBound = sizeBound;
		size = new Dimension(width, height);
	}
	
	public RectangularCollider(int x, int y, Dimension size, boolean isPositionBound, boolean sizeBound){
		super(x, y, isPositionBound);
		this.sizeBound = sizeBound;
		this.size = (Dimension)size.clone();
	}
	
	public Dimension getSize(){
		return (Dimension)size.clone();
	}
	
	public void setSize(Dimension size){
		this.size = (Dimension)size.clone();
		sizeBound = false;
	}
	
	public void setSize(Dimension size, boolean sizeBound){
		this.size = (Dimension)size.clone();
		this.sizeBound = sizeBound;
	}
	
	public int getWidth(){
		return size.width;
	}
	
	public void setWidth(int width){
		size.width = width;
		sizeBound = false;
	}
	
	public void setWidth(int width, boolean isBound){
		sizeBound = isBound;
	}
	
	public int getHeight(){
		return size.height;
	}
	
	public void setHeight(int height){
		size.height = height;
		sizeBound = false;
	}
	
	public void setHeight(int height, boolean isBound){
		size.height = height;
		sizeBound = isBound;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(position.x - size.width/2, position.y - size.height/2, size.width, size.height);
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
