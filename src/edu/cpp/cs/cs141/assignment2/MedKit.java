package edu.cpp.cs.cs141.assignment2;

/**
 * Represents a medkit in <i>Escape the Dungeon!</i> that can restore health
 * @author j
 */
public class MedKit extends ItemDrop {
	/**
	 * Minimum amount healed by this medkit
	 */
	int value = 2;
	
	/**
	 * Increment {@code value} by random integer in range [0, 2]
	 */
	public MedKit() {
		super(3);
	}
}
