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
 * Abstract class intended for {@link Player} and {@link Enemy} classes
 */
public abstract class Character implements Agent {
	
	/**
	 * The amount of maximum health the character can have
	 */
	private int maxHealth;
	
	/**
	 * The amount of health the character has
	 */
	private int health;
	
	/**
	 * The {@link Gun} object the character wields
	 */
	public Gun gun;
	
	/**
	 * The position of the character in the game world
	 */
	protected int position;
	
	/**
	 * Name of this character
	 */
	private String name = "";
	
	/**
	 * Set defaults for character
	 * @param name name of character
	 * @param gun gun the character wields
	 */
	public Character(String name, Gun gun) {
		this.name = name;
		this.maxHealth = 20;
		this.health = maxHealth;
		this.position = 0;
		this.gun = gun;
	}
	
	/**
	 * Specify more attributes
	 * @param name set {@link #name} to name
	 * @param hp set {@link #health} and {@link #maxHealth} to hp
	 * @param pos set {@link #position} to pos
	 * @param gun set {@link #gun} to gun
	 */
	public Character(String name, int hp, int pos, Gun gun) {
		this.name = name;
		this.maxHealth = hp;
		this.health = hp;
		this.position = pos;
		this.gun = gun;
	}
	
	/**
	 * @return name of this character
	 */
	public String name() {
		return name;
	}
	
	/**
	 * @return position of character on board in game
	 */
	public int position() {
		return position;
	}
	
	/**
	 * @return current health of player
	 */
	public int health() {
		return health;
	}
	
	/**
	 * Change {@link #health} value by {@code amount}. Restrict new {@link #health} value
	 * 		to be in the range [0, {@link #maxHealth}]
	 * @param amount value to change health by
	 */
	public void changeHealthBy(int amount) {
		health += amount;
		if (health > maxHealth) {
			health = maxHealth;
		}
		else if (health < 0) {
			health = 0;
		}
	}
	
	/**
	 * Checks if character is dead
	 * @return true or false indicating character is dead
	 */
	public boolean isDead() {
		return health <= 0 ? true: false;
	}
}
