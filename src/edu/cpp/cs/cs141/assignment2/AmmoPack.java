package edu.cpp.cs.cs141.assignment2;

/**
 * Represents an ammopack in <i>Escape the Dungeon!</i>
 * @author j
 */
public class AmmoPack extends ItemDrop {
	
	/**
	 * Construct an ammopack object
	 */
	public AmmoPack() {
		// parameters: name, action message, value, hit probability
		super("Ammo Pack", "refilled %d ammo", 0, 0.70);
	}
}
