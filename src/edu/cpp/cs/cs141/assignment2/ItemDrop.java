package edu.cpp.cs.cs141.assignment2;

import java.util.Random;

/**
 * Shared methods and attributes of all dropable items in <i>Escape the Dungeon</i>
 */
public abstract class ItemDrop implements Item {
	/**
	 * integer value associated with item
	 */
	int value = 0;
	
	/**
	 * Default constructor for ItemDrop
	 * @param incrementLimit(int): set {@code value} by random integer between
	 * 0 and {@param incrementLimit}
	 */
	public ItemDrop(int incrementLimit) {
		Random random = new Random();
		this.value += random.nextInt(incrementLimit);
	}
	
	/**
	 * @return value(int): value of this item
	 */
	public int value() {
		return this.value;
	}
}
