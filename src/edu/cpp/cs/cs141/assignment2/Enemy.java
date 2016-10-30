package edu.cpp.cs.cs141.assignment2;

import java.util.Random;

/**
 * Represents an enemy in game
 */
public class Enemy extends Character {
	
	/**
	 * Probability for pistol, rifle, and shotgun to be picked.
	 */
	private double[] gunPickProb = {0.50, 0.35, 0.15};
	
	/**
	 * Used to generate random numbers
	 */
	private Random random = new Random();
	
	/**
	 * Uses constructor of Character to set attribute values
	 * @param pos position of enemy in game
	 * @param gun gun the enemy wields
	 */
	public Enemy(int pos, Gun gun) {
		// parameters: name, hp, position, gun
		super(GAME_AGENT.Enemy.name(), 5, pos, gun);
	}
	
	/**
	 * Randomly create new gun object and set {@link #gun} attribute of Enemy to gun created
	 */
	public void equipRandomGun() {
		double randomDouble = random.nextDouble();
		if (randomDouble <= gunPickProb[0])
			gun = new Pistol();
		else if (randomDouble <= gunPickProb[0]+gunPickProb[1])
			gun = new Rifle();
		else
			gun = new Shotgun();
	}
}
