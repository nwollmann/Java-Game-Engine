package com.nwollmann.jgame.util;

import java.awt.Point;

public class Vector2D {
	private double x, y;
	
	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Vector2D(Point a, Point b){
		x = b.x - a.x;
		y = b.y - a.y;
	}
	
	public Vector2D add(Vector2D vector){
		return new Vector2D(x + vector.x, y + vector.y);
	}
	
	//subtracts given vector from this vector
	public Vector2D subtract(Vector2D vector){
		return new Vector2D(x - vector.x, y - vector.y);
	}
	
	public Vector2D scalarMultiply(int scalar){
		return new Vector2D(x * scalar, y * scalar);
	}
	
	public double getMagnitude(){
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Vector2D normalize(){
		double magnitude = getMagnitude();
		return new Vector2D(x / magnitude, y / magnitude);
	}
	
	public boolean equals(Vector2D vector){
		return x == vector.x && y == vector.y;
	}
	
	public String toString(){
		return "<" + x + ", " + y + ">";
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
}
