package com.nwollmann.jgame.util;

import java.awt.Point;

/**
 * This vector class offers some utility for various operations.
 * @author Nicholas Wollmann
 *
 */
public class Vector2D {
	private double x, y;
	
	/**
	 * Constructs a new Vector2D with the given dimensions.
	 */
	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructs a new Vector2D from point a to point b.
	 */
	public Vector2D(Point a, Point b){
		x = b.x - a.x;
		y = b.y - a.y;
	}
	
	/**
	 * Adds the given vector to this one, returning the sum.
	 */
	public Vector2D add(Vector2D vector){
		return new Vector2D(x + vector.x, y + vector.y);
	}
	
	/**
	 * Returns the difference between this vector and the parameter.
	 */
	public Vector2D subtract(Vector2D vector){
		return new Vector2D(x - vector.x, y - vector.y);
	}
	
	/**
	 * Returns this vector multiplied by the given scalar.
	 */
	public Vector2D scalarMultiply(int scalar){
		return new Vector2D(x * scalar, y * scalar);
	}
	
	/**
	 * Returns the magnitude of this vector.
	 */
	public double getMagnitude(){
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	/**
	 * Returns the normalization of this vector.
	 */
	public Vector2D normalize(){
		double magnitude = getMagnitude();
		return new Vector2D(x / magnitude, y / magnitude);
	}
	
	/**
	 * Returns whether this vector is equal to the parameter.
	 */
	public boolean equals(Vector2D vector){
		return x == vector.x && y == vector.y;
	}
	
	/**
	 * Returns a string representation of this Vector.
	 */
	public String toString(){
		return "<" + x + ", " + y + ">";
	}
	
	/**
	 * Returns the x component of this vector.
	 */
	public double getX(){
		return x;
	}
	
	/**
	 * Returns the y component of this vector.
	 */
	public double getY(){
		return y;
	}
}
