package edu.cpp.cs.cs141.assignment2;

/**
 * Represents a shotgun in game which is a type of gun
 */
public class Shotgun extends Gun {
	
	/**
	 * Construct a Shotgun object with pre-defined values for attributes
	 */
	public Shotgun() {
		// parameters: name, damage, ammo, accuracy
		super(GUN.shotgun.name(), 5, 7, 0.40);
	}
}
