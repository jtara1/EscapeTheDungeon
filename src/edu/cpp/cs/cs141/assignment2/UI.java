package edu.cpp.cs.cs141.assignment2;

import java.util.Scanner;

/**
 * User Interface (text-based) to communicate with user and get user input
 * @author j
 *
 */
public class UI {
	
	/**
	 * Main player used to get statistics and display them
	 */
	private Player player = null;
	
	/**
	 * Enemy currently associated with ui; used to get statistics and display them
	 */
	private Enemy enemy = null;
	
	/**
	 * Scanner object used to get input for user
	 */
	private Scanner keyboard = null;
	
	/**
	 * Construct a UIText object without any parameters
	 */
	public UI() {
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Construct a UI object
	 * Set {@link player} equal to {@param player} to use to get values of health, position,
	 * gun, etc.
	 */
	public UI(Player player) {
		this.player = player;
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Set attribute player to {@param player}
	 * @param player passed parameter becomes player attribute
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * @param enemy set {@link enemy} to this
	 */
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	
	/**
	 * Welcome user and describe goal of game
	 */
	public void welcome() {
		System.out.printf("Escape the Dungeon!\n" +
				"Can you make it to the great beyond of tile 11?\n");
	}
	
	/**
	 * Asks user what action should be taken next and returns the response
	 * Intended for use when faced with an enemy
	 * @return the response from the user indicates the action he wants
	 */
	public String getCombatAction() {
		String userInput = "";
		String[] options = {"Attack", "Escape"};
		while (userInput != options[0].toLowerCase() ||
				userInput != options[1].toLowerCase()) {
		
			System.out.printf(
					"Enter the name of the gun you'd like to use.\n" +
					"Options: %s or %s\n", 
					options[0], options[1]);
		userInput = keyboard.nextLine().toLowerCase();
		}
		return userInput;
	}
	
	/**
	 * Displays stats of all characters and guns 
	 */
	public void printBoard() {
		if (enemy != null) {
			printBoard(enemy);
			return;
		}
		System.out.printf(
				"Tile you're on: %d\n" +
				"HP: %d\n" +
				"Gun: %s\n" +
				"Probability to Hit Enemy: %0.0f\n" +
				"Damage: %d", 
				player.position(),
				player.health(),
				player.gun.name(),
				player.gun.hitProbability(),
				player.gun.damage());
	}
	
	/**
	 * Displays stats of all characters and guns, but now there's an enemy on the loose
	 */
	public void printBoard(Enemy enemy) {
		System.out.printf(
				"Tile you're on: %d\n" +
				"HP: %d\n" +
				"Gun: %s\n" +
				"Probability to Hit Enemy: %0.0f\n" +
				"Damage: %d\n" +
				"Yo fix this later", 
				player.position(),
				player.health(),
				player.gun.name(),
				player.gun.hitProbability(),
				player.gun.damage());
	}
	
	/**
	 * Prints all possible guns the player can pick, gets user input, calls toLowerCase method
	 * on user input, and returns it if it matches that of a valid gun. 
	 * This function loops until a valid gun name is entered.
	 * @return Only returns the name of the gun (all lowercase) if it's a valid name
	 */
	public String getGunChoice() {
		String userInput = "";
		String[] options = {"Pistol", "Rifle", "Shotgun"};
		while (userInput != options[0].toLowerCase() ||
					userInput != options[1].toLowerCase() ||
					userInput != options[2].toLowerCase()) {
			
			System.out.printf(
					"Enter the name of the gun you'd like to use.\n" +
					"Options: %s, %s, or %s\n", 
					options[0], options[1], options[2]);
			userInput = keyboard.nextLine().toLowerCase();
		}
		return userInput;
	}
	
	/**
	 * Print enemy defeat message
	 */
	public void enemyDefeat() {
		System.out.println("Good job defeating the enemy; keep up the hard work!");
	}
	
	/**
	 * Print game won message
	 */
	public void gameWon() {
		System.out.println("Congratulations, You Won!\n" +
				"Here are your final stats:\n");
		printBoard();
	}
	
	/**
	 * Print game over message
	 */
	public void gameOver() {
		System.out.println("you lost; now git gud");
	}
}
