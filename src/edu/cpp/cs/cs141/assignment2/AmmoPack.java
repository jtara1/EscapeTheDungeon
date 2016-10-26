package edu.cpp.cs.cs141.assignment2;

/**
 * Represents an ammopack in <i>Escape the Dungeon!</i> that can increase amount of ammo for gun
 * @author j
 */
public class AmmoPack extends ItemDrop {
	/**
	 * Minimum amount of ammo this ammopack gives
	 */
	int value = 1;
	
	/**
	 * Increment {@code value} by integer in the range of [0, 1]
	 */
	public AmmoPack() {
		super(2);
	}
}
