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

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Handles game logic and brings everything together
 * @author James Taracevicz
 *
 */
public class GameEngine {
	
	/**
	 * User interface (ui) which handles printing text for user and getting user input
	 */
	private UI ui = null;
	
	/**
	 * The character the user controls
	 */
	private Player player = null;
	
	/**
	 * The enemy that opposes the player
	 */
	private Enemy enemy = null;
	
	/**
	 * MedKit object used as an itemDrop
	 */
	private MedKit medKit = new MedKit();
	
	/**
	 * AmmoPack object used as an itemDrop
	 */
	private AmmoPack ammoPack = new AmmoPack();
	
	/**
	 * The game stops looping when this is true
	 */
	private Boolean gameFinished = false;
	
	/**
	 * Probability player encounters an enemy each time player takes a step
	 */
	private final double encounterProbability = 0.15;
	
	/**
	 * Delay (in milliseconds) before next step
	 */
	private final long stepDelay = 1850;
	
	/**
	 * random object can generate random doubles and integers
	 */
	private Random random = new Random();
	
	/**
	 * Game system settings; includes settings such as autoTakeStepMode
	 */
	private Map<String, Boolean> settings = new HashMap<String, Boolean>();
	
	/**
	 * Initialize attribute(s)	 
	 */
	public GameEngine() {
		ui = new UI();
	}
	
	/**
	 * Start and run game
	 */
	public void run() {
		ui.welcome();
		player = new Player(pickGun());
		setGameSettings();
		
		String proceedQuestion = "Proceed to the next tile (y/n)?";
		String response = "";
		while (!gameFinished) {
			ui.printBoard();
			
			if (settings.get("autoTakeStepMode")) {
				gameSleep(stepDelay);
			}
			else {
				while (!response.equals("y")) {
					response = ui.getYesNoResponse(proceedQuestion);
				}
				response = "";
			}
			takeStep();
				
			if (enemyEncountered()) {
				fightEnemy();
			}
		}
	}
	
	/**
	 * Set settings for game (both game system settings and some attributes that need to be
	 * 		set during runtime)
	 */
	public void setGameSettings() {
		ammoPack.setValue(player.gun.maxAmmo());
		ui.setPlayer(player);
		
		String[] settingsNames = {"autoTakeStepMode"};
		String[] settingsMessages = {"Enable auto-take-step mode (automatically proceeds" +
				" to next tile when possible) (y/n)?"};
		
		String response = "";
		for (int i = 0; i < settingsMessages.length; i++) {
			response = ui.getYesNoResponse(settingsMessages[i]);
			if (response.equals("y")) {
				settings.put(settingsNames[i], true);
			}
			else if (response.equals("n")) {
				settings.put(settingsNames[i], false);
			}
		}
	}
	
	/**
	 * Moves the player to next tile and checks if player reached final tile
	 */
	public void takeStep() {
		if (player.position() == 10) {
			gameWon();
			System.exit(0);
		}
		else {
			player.changePositionBy(1);
		}
	}
	
	/**
	 * Fight an enemy in game, gets player action, and determines what happens in fight
	 */
	public void fightEnemy() {	
		enemy = new Enemy(player.position(), null);
		enemy.equipRandomGun();
		ui.setEnemy(enemy);
		boolean enemyDied = false;
		boolean playerDied = false;

		while (!(enemyDied || playerDied)) {
			ui.printCombatBoard(); // prints board with additional enemy info			
			// player action
			enemyDied = playerCombatTurn();
			// enemy action			
			if (!enemyDied)
				playerDied = enemyCombatTurn();
		}
		ui.setEnemy(null);
	}
	
	/**
	 * Do all actions involved in player's turn while in combat
	 * @return true if enemy has been killed or player has escaped, false otherwise
	 */
	public boolean playerCombatTurn() {
		String userAction;
		boolean hitTarget;
		int damageDealt = 0;
		
		userAction = ui.getCombatAction();
		if (userAction.equals(COMBAT_ACTION.attack.name())) {
			hitTarget = player.gun.fire();
			if (hitTarget) {
				damageDealt = player.gun.damage();
				enemy.changeHealthBy(-1 * damageDealt);
			}
			else if (!hitTarget) {
				damageDealt = 0;
			}
			ui.combatReport(player.name(), enemy.name(), damageDealt);
			if (enemy.isDead()) {
				ui.enemyDefeated();
				acquireItemDrop();
				return true;
			}
		}
		else if (userAction.equals(COMBAT_ACTION.escape.name())) {
			if (player.escapeSucceeded()) {
				ui.playerEscaped();
				player.changePositionBy(-1);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Do all actions involved in enemy's turn during combat
	 * @return true if player was defeated or the enemy ran away (due to lack of ammo, 
	 * 		false otherwise
	 */
	public boolean enemyCombatTurn() {
		boolean hitTarget;
		int damageDealt = 0;
		
		if (enemy.gun.ammo() <= 0) {
			ui.enemyRanAway(true);
			return true;
		}
		hitTarget = enemy.gun.fire();
		if (hitTarget) {
			damageDealt = enemy.gun.damage();
			player.changeHealthBy(-1 * damageDealt);
		}
		else if (!hitTarget) {
			damageDealt = 0;
		}
		ui.combatReport(enemy.name(), player.name(), damageDealt);
		if (player.isDead()) {
			gameOver();
			return true;
		}
		return false;
	}
	
	/**
	 * Handles the actions that should be taken when an item drops
	 */
	public void acquireItemDrop() {
		ItemDrop item = getRandomItem();
		if (item.name().equals(medKit.name())) {
			player.changeHealthBy(item.value());
		}
		else if (item.name().equals(ammoPack.name())) {
			player.gun.changeAmmoBy(item.value());
		}
		ui.itemAcquired(item);
	}
	
	
	/**
	 * Use UI method {@link UI#getGunChoice} to prompt user to select a gun
	 * then create a gun object based on String of what user chose
	 * @return gun object created
	 */
	public Gun pickGun() {
		Gun gun;
		String gunName = ui.getGunChoice();
		if (gunName.equals(GAME_GUN.pistol.name())) {
			gun = new Pistol();
		}
		else if (gunName.equals(GAME_GUN.rifle.name())) {
			gun = new Rifle();
		}
		else if (gunName.equals(GAME_GUN.shotgun.name())) {
			gun = new Shotgun();
		}
		else {
			gun = new Shotgun();
		}
		return gun;
	}
	
	/**
	 * Randomly pick a gun; {@link Enemy#equipRandomGun()} also does something similar
	 * @return the gun object picked
	 */
	public Gun pickRandomGunForEnemy() {
		double[] gunPickProb = {0.50, 0.35, 0.15}; // gun pick probabilities
		double randomDouble = random.nextDouble();
		if (randomDouble <= gunPickProb[0])
			return new Pistol();
		else if (randomDouble <= gunPickProb[0]+gunPickProb[1])
			return new Rifle();
		else
			return new Shotgun();
	}
	
	/**
	 * @return true if enemy has been encountered false otherwise
	 */
	public boolean enemyEncountered() {
		return random.nextDouble() <= encounterProbability ? true: false;
	}
	
	/**
	 * @return random {@link ItemDrop} object 
	 */
	public ItemDrop getRandomItem() {
		if (random.nextDouble() <= medKit.dropProbability()) {
			return medKit;
		}
		return ammoPack;
	}
	
	/**
	 * System sleeps for given amount of time
	 * @param sleep The amount of time (in milliseconds) to sleep for
	 */
	public void gameSleep(long sleep) {
		try {
			Thread.sleep(sleep);
		}
		catch (InterruptedException e) {
		}
	}
	
	/**
	 * You won this ez game.
	 */
	public void gameWon() {
		gameFinished = true;
		ui.gameWon();
	}
	
	/**
	 * You Died.
	 */
	public void gameOver() {
		gameFinished = true;
		ui.gameOver();
	}
}
