/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #2
 * 
 * <i>Escape the Dungeon!</i>
 * 	Simple and short text-based adventure game in which you progress through a linear dungeon
 * 	shooting and looting enemies.
 *
 * @author James Taracevicz
 */

package edu.cpp.cs.cs141.assignment2;

/**
 * Represents a shotgun in game which is a type of gun
 */
public class Shotgun extends Gun {
	
	/**
	 * Construct a Shotgun object with pre-defined values for attributes
	 */
	public Shotgun() {
		// parameters: name, damage, ammo, accuracy
		super(GAME_GUN.shotgun.name(), 5, 7, 0.40);
	}
}
