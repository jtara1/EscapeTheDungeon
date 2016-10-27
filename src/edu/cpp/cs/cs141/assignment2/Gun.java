package edu.cpp.cs.cs141.assignment2;

import java.util.Random;

/**
 * Gun classes abstracting a gun in <i>Escape the Dungeon!</i> game
 */
public abstract class Gun {
	
	/**
	 * Name of gun
	 */
	private String name = "gun";
	
	/**
	 * Amount of damage the gun deals
	 */
	private int damage = 0;
	
	/**
	 * Maximum amount of ammunition 
	 */
	private int maxAmmo = 0;
	
	/**
	 * Amount of ammunition for the gun
	 */
	private int ammo = 0;
	
	/**
	 * Used to generate random numbers
	 */
	private Random random = null;
	
	/**
	 * Probability the gun bullet hits its target 
	 */
	private double accuracy = 0.0;
	
	/**
	 * Default constructor for gun
	 * @param name: set attribute name to this value
	 * @param ammo: set attribute ammo to this value
	 * @param damage: set attribute damage to this value
	 * @param hitProbability: set attribute accuracy to this value
	 */
	public Gun(String name, int damage, int ammo, double hitProbability) {
		this.name = name;
		this.damage = damage;
		this.ammo = ammo;
		this.maxAmmo = ammo;
		this.accuracy = hitProbability;
		this.random = new Random();
	}
	
	/**
	 * @return the name of this gun
	 */
	public String name() {
		return name;
	}
	
	/**
	 * @return the amount of damage this gun deals
	 */
	public int damage() {
		return damage;
	}
	
	/**
	 * @return the {@link hitProbability} of the gun
	 */
	public double accuracy() {
		return accuracy;
	}
	
	/**
	 * @return the amount of {@link ammo} for the gun 
	 */
	public int ammo() {
		return ammo;
	}
	
	/**
	 * @return the maximum amount of {@link ammo} for the gun
	 */
	public int maxAmmo() {
		return maxAmmo;
	}
	
	/**
	 * @return {@code true} if gun bullet hit target, {@code false} otherwise
	 */
	public boolean hitTarget() {
		return random.nextDouble() <= accuracy ? true: false;
	}
	
	/**
	 * Change {@link ammo} value by {@param amount}
	 */
	public void changeAmmoBy(int amount) {
		ammo += amount;
		if (ammo > maxAmmo) 
			ammo = maxAmmo;
		else if (ammo < 0) 
			ammo = 0;
	}
	
	/**
	 * @return true if there's enough ammo for bullet and target was hit 
	 */
	public boolean fire() {
		if (ammo > 0) {
			changeAmmoBy(-1);
			if (hitTarget()) {
				return true;
			}	
		}
		return false;	
	}
}
