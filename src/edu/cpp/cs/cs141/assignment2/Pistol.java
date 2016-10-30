package edu.cpp.cs.cs141.assignment2;

/**
 * Represents a pistol in game which is a type of gun
 */
public class Pistol extends Gun {
	
	/**
	 * Construct a Pistol object with pre-defined values for attributes
	 */
	public Pistol() {
		// parameters: name, damage, ammo, accuracy
		super(GAME_GUN.pistol.name(), 1, 10, 0.75);
	}
}
