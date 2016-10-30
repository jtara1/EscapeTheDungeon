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
 * Represents an ammo pack in <i>Escape the Dungeon!</i>
 * @author j
 */
public class AmmoPack extends ItemDrop {
	
	/**
	 * Construct an ammopack object
	 * Note: The amount of the ammo in the pack is determined by the type of the gun
	 * which can be done by using {@link ItemDrop#setValue}
	 */
	public AmmoPack() {
		// parameters: name, action message, value, hit probability
		super("Ammo Pack", "refilled %d ammo", 0, 0.70);
	}
}
