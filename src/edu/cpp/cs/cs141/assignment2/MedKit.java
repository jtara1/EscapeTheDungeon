package edu.cpp.cs.cs141.assignment2;

/**
 * Represents a medkit in <i>Escape the Dungeon!</i> that can restore health
 * @author j
 */
public class MedKit extends ItemDrop {
	
	/**
	 * Construct a medkit object
	 */
	public MedKit() {
		// parameters: name, action message, value, hit probability
		super("Med Kit", "restored %d health", 5, 0.30);
	}
}
