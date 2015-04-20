package com.nwollmann.jgame.util;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

import com.nwollmann.jgame.graphics.GameRenderer;
import com.nwollmann.jgame.physics.Collider;
import com.nwollmann.jgame.physics.RectangularCollider;

/**
 * This is the base class for all objects registered with the Game Manager.
 * Any objects with special update or onCollision functionality should be
 * implemented as child classes.
 * @author Nicholas Wollmann
 *
 */
public class GameObject {
	protected GameRenderer renderer;
	private int posX, posY;
	protected int layer;
	private Dimension size;
	protected boolean collidable;
	protected boolean visible;
	protected boolean deleteFlag;
	protected boolean collideFlag;
	protected Collider collider;
	
	/**
	 * Creates a game object. By default it is not visible, has no renderer, and is not collidable.
	 */
	public GameObject(){
		//put in some default renderer, probably a color renderer with a random color?
		collidable = false;
		visible = false;
		size = new Dimension(100, 100);
		collider = new RectangularCollider();
		collider.setParent(this);
	}
	
	/**
	 * Sets the location of this game object. If the game object is collidable then it
	 * will also perform  collision check.
	 * @param x Horizontal location in pixels
	 * @param y Vertical location in pixels
	 */
	public final void setPosition(int x, int y){
		posX = x;
		posY = y;
		if(collider.isPositionBound()) collider.setPosition(x, y, true);
		if(collidable) collideFlag = true;
	}
	
	/**
	 * Sets the horizontal location of the game object. If the game object is
	 * collidable then it will also perform a collision check.
	 * @param x Horizontal location in pixels
	 */
	public final void setPositionX(int x){
		posX = x;
		if(collider.isPositionBound()) collider.setPositionX(x, true);
		if(collidable) collideFlag = true;
	}
	
	/**
	 * Sets the vertical location of this game object. If the game object is collidable
	 * then it will also perform a collision check.
	 * @param y Vertical location in pixels
	 */
	public final void setPositionY(int y){
		posY = y;
		if(collider.isPositionBound()) collider.setPositionY(y, true);
		if(collidable) collideFlag = true;
	}
	
	/**
	 * Returns the current position of the game object.
	 * @return A point containing the current location
	 */
	public final Point getPosition(){
		return new Point(posX, posY);
	}
	
	/**
	 * Shifts the game object by the given values. If the game object
	 * is collidable then will also perform a collision check.
	 * @param x Pixels to add to horizontal location
	 * @param y Pixels to add to vertical location
	 */
	public final void translate(int x, int y){
		posX += x;
		posY += y;
		if(collider.isPositionBound()) collider.setPosition(posX, posY);
		if(collidable) collideFlag = true;
	}
	
	/**
	 * Shifts the game object horizontally by the given value. If the game
	 * object is collidable then will also perform a collision check.
	 * @param x Pixels to add to horizontal location
	 */
	public final void translateX(int x){
		posX += x;
		if(collider.isPositionBound()) collider.setPositionX(posX, true);
		if(collidable) collideFlag = true;
	}
	
	/**
	 * Shifts the game object vertically by the given value. If the game object
	 * is collidable then will also perform a collision check.
	 * @param y Pixels to add to vertical location
	 */
	public final void translateY(int y){
		posY += y;
		if(collider.isPositionBound()) collider.setPositionY(posY, true);
		if(collidable) collideFlag = true;
	}
	
	/**
	 * Sets the size of this game object. If the game object is collidable then
	 * will also perform a collision check.
	 * @param size The new size for the game object in pixels
	 */
	public final void setSize(Dimension size){
		this.size = size;
		if(collidable) collideFlag = true;
		if(collider.isSizeBound()) collider.updateSize(size, true);
	}
	
	/**
	 * Sets the width of this game object. If the game object is collidable then
	 * will also perform a collision check.
	 * @param width The new width in pixels
	 */
	public final void setWidth(int width){
		size.width = width;
		if(collidable) collideFlag = true;
		if(collider.isSizeBound()) collider.updateSize(size, true);
	}
	
	/**
	 * Sets the height of this game object. If the game object is collidable then
	 * will also perform a collision check.
	 * @param height The new height in pixels
	 */
	public final void setHeight(int height){
		size.height = height;
		if(collidable) collideFlag = true;
		if(collider.isSizeBound()) collider.updateSize(size, true);
	}
	
	/**
	 * Gets the current size of the game object as a Dimension object.
	 * @return Size in pixels
	 */
	public final Dimension getSize(){
		return (Dimension)size.clone();
	}
	
	/**
	 * Sets whether this game object is checked for collision.
	 * @param collidable True for collision to be possible
	 */
	public void setCollidable(boolean collidable){
		this.collidable = collidable;
	}
	
	/**
	 * Returns whether this game object is collidable.
	 * @return True if collision is possible
	 */
	public boolean isCollidable(){
		return collidable;
	} 
	
	/**
	 * Sets whether or not this game object is drawn on screen.
	 * @param visible True if you wish the game object to be rendered
	 */
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	/**
	 * Returns whether or not this game object is to be drawn on screen.
	 * @return True if it will be drawn
	 */
	public boolean isVisible(){
		return visible;
	}
	
	/**
	 * Sets the layer in which the game object should be drawn. A higher number
	 * will result in the object being drawn closer to the foreground.
	 * @param layer Layer in which to draw this game object
	 */
	public void setLayer(int layer){
		this.layer = layer;
	}
	
	/**
	 * Returns the layer in which this game object should be drawn. A higher
	 * number will result in the object being drawn closer to the foreground.
	 * @return Layer in which to draw this game object
	 */
	public int getLayer(){
		return layer;
	}
	
	/**
	 * This will mark the object for deletion as soon as the game manager finishes
	 * the current update cycle. Once flagged this object will be removed from
	 * the game manager, meaning it will no longer be updated, rendered on screen,
	 * or checked for collision. It will not, however, nullify this object if you
	 * still have references to it within your code.
	 */
	public void flagForDeletion(){
		deleteFlag = true;
	}
	
	/**
	 * Returns whether the object is currently flagged for deletion. This will return
	 * false until a call is made to the flagForDeletion method after which it will
	 * return true.
	 * @return True if the object is flagged for deletion
	 */
	public boolean isFlaggedForDeletion(){
		return deleteFlag;
	}
	
	public void deflagForCollision(){
		collideFlag = false;
	}
	
	public boolean isFlaggedForCollision(){
		return collideFlag;
	}
	
	/**
	 * Sets the renderer to be used when drawing this game object.
	 * @param renderer Renderer to draw this game object
	 */
	public void setRenderer(GameRenderer renderer){
		this.renderer = renderer;
	}
	
	/**
	 * Returns the renderer to be used when drawing this game object.
	 * @return Renderer to draw this game object
	 */
	public GameRenderer getRenderer(){
		return renderer;
	}
	
	/**
	 * Draws this game object at its current location using the set
	 * renderer.
	 */
	public void draw(Graphics2D graphics){
		renderer.render(posX, posY, size, graphics);
		
	}
	
	/**
	 * Sets the collider of this game object.
	 */
	public void setCollider(Collider collider){
		if(collider.isPositionBound()){
			collider.setPosition(getPosition(), true);
			collider.updateSize(size, true);
		}
		collider.setParent(this);
		this.collider = collider;
	}
	
	/**
	 * Returns the collider of this game object.
	 */
	public Collider getCollider(){
		return collider;
	}
	
	/**
	 * Code to be called when this game object collides with another.
	 * @param object The other object involved in the collision.
	 */
	public void onCollision(GameObject object){
		//implement on a subclass basis, may end up having a parameter for the other object in the collision [probably should]
	}
	
	/**
	 * Code to run on every update cycle in the game engine (default of 15 miliseconds).
	 */
	public void update(){
		//not sure yet if this will be called every frame or if there will be an ability to set # of frames between calls.
	}
}
