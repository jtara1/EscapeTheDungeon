package edu.cpp.cs.cs141.assignment2;

/**
 * Interface for ultimately creating classes such as {@link Player}  and {@link Enemy}
 */
public interface Agent {
	
	/**
	 * Get position of agent
	 * @return {@code integer} of position of agent
	 */
	public abstract int position();
	
	/**
	 * Get health of agent
	 * @return {@code integer} of current health of agent
	 */
	public abstract int health();
	
	/**
	 * Change agent health value by {@code amount}
	 * @param amount value to decrease health by
	 */
	public abstract void changeHealthBy(int amount);
	
	/**
	 * Check if agent health is less than or equal to 0
	 * @return {@code true} if agent is dead else return {@code false}
	 */
	public abstract boolean isDead();
}
