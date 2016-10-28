package edu.cpp.cs.cs141.assignment2;

/**
 * Interface to represent abstraction of items that can be obtained
 * in <i>Escape the Dungeon!</i>
 */
public interface Item {
	
	/**
	 * @return name of what this object represents
	 */
	public abstract String name();
	
	/**
	 * @return past tense of action taken when item is applied
	 */
	public abstract String action();
	
	/**
	 * @return value value attribute of object
	 */
	public abstract int value();
	
	/**
	 * @param value set attribute {@link #value} to {@code value}
	 */
	public abstract void setValue(int value);
	
	/**
	 * @return the probability the item drops
	 */
	public abstract double dropProbability();
}
