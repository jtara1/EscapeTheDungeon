package edu.cpp.cs.cs141.assignment2;

import java.util.Scanner;

/**
 * User Interface (text-based) to display info to user and get user input
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
	 * Used in print formatting to determine total (horizontal) characters in player 
	 * 		stats text body
	 */
	private final int playerTextBodyLength = 28;
	
	/**
	 * Integer used in print formatting to determine amount of characters between player and
	 * 		enemy gun names
	 */
	private int distanceBetweenGunNames = 0;
	
	/**
	 * Construct a UIText object without any parameters
	 */
	public UI() {
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Construct a UI object
	 * Set {@link #player} equal to {@code player} to use to get values of health, position,
	 * 		gun, etc.
	 */
	public UI(Player player) {
		// calls UI() (default constructor)
		this(); 
		setPlayer(player);
	}
	
	/**
	 * Set attribute player to {@code player} and determine how much whitespace needed 
	 * 		between player and enemy gun prints
	 * @param player passed parameter becomes player attribute
	 */
	public void setPlayer(Player player) {
		this.player = player;
		String playerGunName = String.format("Gun: %s", player.gun.name());
		distanceBetweenGunNames = playerTextBodyLength - playerGunName.length();
	}
	
	/**
	 * @param enemy set {@link #enemy} to this
	 */
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	
	/**
	 * Welcome user and describe goal of game
	 */
	public void welcome() {
		System.out.printf("Escape the Dungeon!\n" +
				"Can you make it to the great beyond of tile 10?\n");
	}
	
	/**
	 * Get yes or no (y/n) response from user
	 * @param message Should include String {@code "(y/n)"} in the message
	 */
	public String getYesNoResponse(String message) {
		String response = "";
		System.out.println(message);
		while (!response.equals("y") && !response.equals("n")) {
			response = removeCRLF(keyboard.nextLine().toLowerCase().trim());
		}
		return response;
	}
	
	/**
	 * Asks user what action should be taken next and returns the response
	 * Intended for use when faced with an enemy
	 * @return the response from the user indicates the action he wants
	 */
	public String getCombatAction() {
		String userInput = "";
		while (!userInput.equals(COMBAT_ACTION.attack.name()) &&
				!userInput.equals(COMBAT_ACTION.escape.name())) {
		
			System.out.printf(
					"A fearsome enemy stands in your way.\n" +
					"Options: %s or %s\n",
					COMBAT_ACTION.attack.name(), COMBAT_ACTION.escape.name());
		userInput = removeCRLF(keyboard.nextLine().toLowerCase().trim());
		}
		return userInput;
	}
	
	/**
	 * Displays stats of all characters and guns 
	 */
	public void printBoard() {
		System.out.printf(
				"Tile you're on: %d\n" +
				"HP: %02d\n" +
				"Gun: %s\n" +
				"Ammo: %03d\n" +
				"Accuracy: %.2f\n" +
				"Damage: %d\n\n", 
				player.position(),
				player.health(),
				player.gun.name(),
				player.gun.ammo(),
				player.gun.accuracy(),
				player.gun.damage());
	}
	
	/**
	 * Displays stats of all characters and guns, but now there's an enemy on the loose
	 */
	public void printBoard(Enemy enemy) {	
		System.out.printf(
				"Tile you're on: %d\n" +
				"%s Stats:%15s%s Stats:\n" +
				"HP: %02d%22sHP: %02d\n" +
				"Gun: %s%" + distanceBetweenGunNames + "sGun: %s\n" +
				"Ammo: %03d%19sAmmo: %03d\n" +
				"Accuracy: %.2f%14sAccuracy: %.2f\n" +
				"Damage: %d%19sDamage: %s\n\n",
				player.position(),
				player.name(), "", enemy.name(),
				player.health(), "", enemy.health(),
				player.gun.name(), "", enemy.gun.name(),
				player.gun.ammo(), "", enemy.gun.ammo(),
				player.gun.accuracy(), "", enemy.gun.accuracy(),
				player.gun.damage(), "", enemy.gun.damage());
	}
	
	/**
	 * Displays stats of all characters and guns, but now there's an enemy on the loose
	 */
	public void printCombatBoard() {	
		System.out.printf(
				"Tile you're on: %d\n" +
				"%s Stats:%15s%s Stats:\n" +
				"HP: %02d%22sHP: %02d\n" +
				"Gun: %s%" + distanceBetweenGunNames + "sGun: %s\n" +
				"Ammo: %03d%19sAmmo: %03d\n" +
				"Accuracy: %.2f%14sAccuracy: %.2f\n" +
				"Damage: %d%19sDamage: %s\n\n",
				player.position(),
				player.name(), "", enemy.name(),
				player.health(), "", enemy.health(),
				player.gun.name(), "", enemy.gun.name(),
				player.gun.ammo(), "", enemy.gun.ammo(),
				player.gun.accuracy(), "", enemy.gun.accuracy(),
				player.gun.damage(), "", enemy.gun.damage());
	}
	
	/**
	 * Print message notifying who dealt damage to who and for how much damage
	 * @param target the one who received the damage
	 * @param dealer the one who dealt it
	 * @param damageTaken amount of damage dealt
	 */
	public void combatReport(String dealer, String target, int damageTaken) {
		System.out.printf("%s dealt %d damage to %s.\n", dealer, damageTaken, target);
	}
	
	/**
	 * Print message notifying event of enemy running away
	 * @param noAmmo if true this indicates the enemy had no ammo
	 */
	public void enemyRanAway(boolean noAmmo) {
		String extraInfo = noAmmo ? " since he had no more ammo": "";
		System.out.println("Enemy ran off" + extraInfo);
	}
	
	/**
	 * Remove '\n' and '\r' characters from string
	 */
	private String removeCRLF(String string) {
		return string.replace("\n", "").replace("\r", "");
	}
	
	/**
	 * Prints all possible guns the player can pick, gets user input, calls toLowerCase method
	 * on user input, and returns it if it matches that of a valid gun. 
	 * This function loops until a valid gun name is entered.
	 * @return Only returns the name of the gun (all lowercase) if it's a valid name
	 */
	public String getGunChoice() {
		String userInput = "";
		while (!userInput.equals(GAME_GUN.pistol.name()) &&
					!userInput.equals(GAME_GUN.rifle.name()) &&
					!userInput.equals(GAME_GUN.shotgun.name())) {
			
			System.out.printf(
					"Enter the name of the gun you'd like to use.\n" +
					"Options: %s, %s, or %s\n", 
					GAME_GUN.pistol.name(), GAME_GUN.rifle.name(), GAME_GUN.shotgun.name());
			userInput = removeCRLF(keyboard.nextLine().toLowerCase().trim());
		}
		return userInput;
	}
	
	/**
	 * Print enemy defeat message
	 */
	public void enemyDefeated() {
		System.out.println("Good job defeating the enemy; lets see what it dropped!");
	}
	
	/**
	 * Print item acquired message
	 */
	public void itemAcquired(ItemDrop item) {
		System.out.printf("You picked up and used %s which %s.\n", item.name(), item.action());
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
		System.out.println("you lost; now git gud\n" +
				"Here's your final stats from the previous combat session:\n");
		printCombatBoard();
		
	}
}
