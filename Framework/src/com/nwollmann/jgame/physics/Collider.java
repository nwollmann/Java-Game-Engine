package com.nwollmann.jgame.physics;

import java.awt.Point;

import com.nwollmann.jgame.GameObject;

public class Collider {
	protected boolean positionBound;
	protected Point position;
	protected GameObject parent;
	
	public Collider(){
		positionBound = true;
		position = new Point(0, 0);
	}
	
	public Collider(int x, int y){
		positionBound = true;
		position = new Point(x, y);
	}
	
	public Collider(int x, int y, boolean positionBound){
		this.positionBound = positionBound;
		position = new Point(x, y);
	}
	
	public void setParent(GameObject parent){
		this.parent = parent;
	}
	
	public GameObject getParent(){
		return parent;
	}
	
	public boolean isPositionBound(){
		return positionBound;
	}
	
	public void setPositionBound(boolean positionBound){
		this.positionBound = positionBound;
	}
	
	public Point getPosition(){
		return (Point)position.clone();
	}
	
	public int getPositionX(){
		return position.x;
	}
	
	public int getPositionY(){
		return position.y;
	}
	
	public void setPosition(Point position){
		positionBound = false;
		this.position = position;
	}
	
	public void setPosition(int x, int y){
		positionBound = false;
		position.x = x;
		position.y = y;
	}
	
	public void setPositionX(int x){
		positionBound = false;
		position.x = x;
	}
	
	public void setPositionY(int y){
		positionBound = false;
		position.y = y;
	}
	
	public void setPosition(Point position, boolean positionBound){
		this.positionBound = positionBound;
		this.position = position;
	}
	
	public void setPosition(int x, int y, boolean positionBound){
		this.positionBound = positionBound;
		position.x = x;
		position.y = y;
	}
	
	public void setPositionX(int x, boolean positionBound){
		this.positionBound = positionBound;
		position.x = x;
	}
	
	public void setPositionY(int y, boolean positionBound){
		this.positionBound = positionBound;
		position.y = y;
	}
}
