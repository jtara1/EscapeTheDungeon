package edu.cpp.cs.cs141.assignment2;

import java.util.Random;

/**
 * Represents the user's character he controls in game
 */
public class Player extends Character {
	
	/**
	 * Probability of escape
	 */
	private double escapeProbability = 0.1;
	
	/**
	 * Random used for generating random doubles
	 */
	private Random random = new Random();
		
	/**
	 * Construct Player object at default starting point and health defined in super constructor  
	 * @param gun The gun the player has equipped
	 */
	public Player(Gun gun) {
		super(AGENT.Player.name(), gun);
	}
	
	/**
	 * Alternative constructor that allows specification of player name, hp and gun
	 * @param name name of player
	 * @param hp amount of hit points
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
	 * @return true if the player successfully escaped
	 */
	public boolean escapeSucceeded() {
		return random.nextDouble() <= escapeProbability ? true: false;
	}
}
