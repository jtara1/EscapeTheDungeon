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
	 * The {@link Gun} object the character has
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
	 * Set defaults for character with no parameters passed in constructor
	 */
	public Character(String name, Gun gun) {
		this.name = name;
		this.maxHealth = 20;
		this.health = maxHealth;
		this.position = 0;
		this.gun = gun;
	}
	
	/**
	 * Specify attributes with parameters in constructor
	 * @param hp set {@link health} and {@link maxHealth} to hp
	 * @param pos set {@link position} to pos
	 * @param gun set {@link gun} to gun
	 */
	public Character(String name, int hp, int pos, Gun gun) {
		this.name = name;
		this.maxHealth = hp;
		this.health = hp;
		this.position = pos;
		this.gun = gun;
	}
	
	/**
	 * @return name (String) of this character
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
	 * Change {@link health} value by {@param amount}. If new {@link health} value exceeds
	 * that of {@link maxHealth}, then set {@link health} to {@link maxHealth}
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
