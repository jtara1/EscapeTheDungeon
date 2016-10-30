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
 * Interface for ultimately creating classes such as {@link Player}  and {@link Enemy}
 */
public interface Agent {
	
	/**
	 * @return position of agent in game
	 */
	public abstract int position();
	
	/**
	 * @return current health of agent
	 */
	public abstract int health();
	
	/**
	 * @param amount value to change health by
	 */
	public abstract void changeHealthBy(int amount);
	
	/**
	 * Check if agent health is less than or equal to 0
	 * @return {@code true} if agent is dead else return {@code false}
	 */
	public abstract boolean isDead();
}
