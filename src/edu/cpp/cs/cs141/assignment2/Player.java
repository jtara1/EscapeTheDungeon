package edu.cpp.cs.cs141.assignment2;

import java.util.Random;

/**
 * Player class represents the user's character he controls in game
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
	 * @param gun: The gun the player will be holding
	 */
	public Player(Gun gun) {
		super("Player", gun);
	}
	
	/**
	 * Change player {@link position} by {@param value}
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
