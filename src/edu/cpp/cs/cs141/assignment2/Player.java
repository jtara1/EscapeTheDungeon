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

import java.util.Random;

/**
 * Represents the user's character he controls in game
 */
public class Player extends Character {
	
	/**
	 * Probability of escape
	 */
	private final double escapeProbability = 0.1;
	
	/**
	 * Random used for generating random doubles
	 */
	private Random random = new Random();
		
	/**
	 * Construct Player object at default starting point and health defined in super constructor  
	 * @param gun The gun the player has equipped
	 */
	public Player(Gun gun) {
		super(GAME_AGENT.Player.name(), gun);
	}
	
	/**
	 * Alternative constructor that allows specification of player name, hp and gun
	 * @param name name of player
	 * @param hp amount of current and max hit points
	 * @param gun gun the player wields
	 */
	public Player(String name, int hp, Gun gun) {
		// parameters: name, hp, position, gun
		super(name, hp, 0, gun);
	}
	
	/**
	 * Change player {@link #position} by {@code value}
	 */
	public void changePositionBy(int value) {
		this.position += value;
		if (this.position < 0) {
			this.position = 0;
		}
	}
	
	/**
	 * @return true if the player successfully escaped else false
	 */
	public boolean escapeSucceeded() {
		return random.nextDouble() <= escapeProbability ? true: false;
	}
}
