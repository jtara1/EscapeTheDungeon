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
 * Represents a medkit in <i>Escape the Dungeon!</i> that can be used to restore health
 * @author James Taracevicz
 */
public class MedKit extends ItemDrop {
	
	/**
	 * Construct a medkit object
	 */
	public MedKit() {
		// parameters: name, action message, value, hit probability
		super("Med Kit", "restored %d health", 5, 0.30);
	}
}
