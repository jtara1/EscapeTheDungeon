/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #2
 * 
 * <i>Escape the Dungeon!</i>
 * 	Simple and short text-based adventure game in which you progress through a linear dungeon
 * 	shooting and looting enemies.
 *
 * @author James Taracevicz
 */

package edu.cpp.cs.cs141.assignment2;

/**
 * Shared methods and attributes of all items that can be dropped in <i>Escape the Dungeon!</i>
 */
public abstract class ItemDrop implements Item {
	
	/**
	 * Name of the item
	 */
	private String name = "";
	
	/**
	 * Description of action when item is applied
	 */
	private String action = "";
	
	/**
	 * Integer value associated with item
	 */
	private int value = 0;
	
	/**
	 * Chance of item dropping 
	 */
	private double dropProbability = 0.0;
	
	/**
	 * Constructor for item drops
	 * @param name set {@link #name} to this value
	 * @param action describes the action taken when item is used and is yet
	 * 		to be formatted to inject value of {@link #value}
	 * @param value set {@link #value} to {@code value}
	 * @param dropProbability set {@link #dropProbability} to this value
	 */
	public ItemDrop(String name, String action, int value, double dropProbability) {
		this.name = name;
		this.value = value;
		this.action = action;
		this.dropProbability = dropProbability;
	}
	
	/**
	 * @return name of what this object represents
	 */
	public String name() {
		return name;
	}
	
	/**
	 * @return past tense of action taken when item is applied
	 */
	public String action() {
		return String.format(action, value);
	}
	
	/**
	 * @return {@link #value} of this item
	 */
	public int value() {
		return value;
	}
	
	/**
	 * @param value set attribute value to {@code value}
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * @return the probability this item drops
	 */
	public double dropProbability() {
		return dropProbability;
	}
}
