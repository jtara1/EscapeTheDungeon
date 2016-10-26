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
	 * @return {@code true} if gun bullet hit target, {@code false} otherwise
	 */
	public boolean hitTarget() {
		return random.nextDouble() <= accuracy ? true: false;
	}
	
	/**
	 * Change {@link ammo} value by {@param amount}
	 */
	public void changeAmmoBy(int amount) {
		this.ammo += amount;
	}
	
	/**
	 * Fire the gun and call other necessary methods
	 * @return {@code 1} if bullet hit target, {@code 0} if bullet missed target, and
	 * {@code 2} if there's no more ammo 
	 */
//	public int fire() {
//		if (this.ammo <= 0) {
//			return 2;
//		}
//		changeAmmoBy(-1);
//		if (hitTarget()) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
//	}
	
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
