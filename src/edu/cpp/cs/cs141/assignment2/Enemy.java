package edu.cpp.cs.cs141.assignment2;

public class Enemy extends Character {
	/**
	 * Represents an enemy in game
	 */
	
	/**
	 * Uses constructor of Character to set attribute values
	 * @param pos
	 * @param gun
	 */
	public Enemy(int pos, Gun gun) {
		super(5, pos, gun);
	}
}
