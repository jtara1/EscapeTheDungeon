package edu.cpp.cs.cs141.assignment2;

/**
 * Represents a rifle in game which is a type of gun
 */
public class Rifle extends Gun {
	
	/**
	 * Construct a Rifle object with pre-defined values for attributes
	 */
	public Rifle() {
		// parameters: name, damage, ammo, accuracy
		super(GAME_GUN.rifle.name(), 2, 12, 0.65);
	}
}
