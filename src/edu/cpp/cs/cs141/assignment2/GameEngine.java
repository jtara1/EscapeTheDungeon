package edu.cpp.cs.cs141.assignment2;

import java.util.Random;

/**
 * Handles game logic
 * @author j
 *
 */
public class GameEngine {
	
	/**
	 * User interface (ui) which handles printing text for user and getting user input
	 */
	private UI ui;
	
	/**
	 * The character the user controls
	 */
	private Player player;
	
	/**
	 * The game stops looping when this is true
	 */
	private boolean gameFinished = false;
	
	/**
	 * Probability player encounters an enemy each time player takes a step
	 */
	private final double encounterProbability = 0.15;
	
	/**
	 * Delay (in milliseconds) after a step has been taken and there's no enemy
	 */
	private long stepDelay = 1000;
	
	/**
	 * random object can generate random doubles and integers
	 */
	private Random random = new Random();
	
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
		ui.setPlayer(player);
		
		while (!gameFinished) {
			ui.printBoard();
			takeStep();
			gameSleep(stepDelay);	
			if (enemyEncountered()) {
				fightEnemy();
			}
		}
	}
	
	/**
	 * Moves the player to next tile and checks if player reached final title
	 */
	public void takeStep() {
		if (player.position() == 10) {
			gameWon();
		}
		else {
			player.changePositionBy(1);
		}
	}
	
	/**
	 * Fight an enemy in game, gets player action, and determines what happens in fight
	 */
	public void fightEnemy() {
		String userAction = "";
		boolean hitTarget = false;
		Enemy enemy = new Enemy(player.position(), pickRandomGunForEnemy());
		
		while (!(player.isDead() || enemy.isDead())) {
			ui.printBoard(enemy);
			userAction = ui.getCombatAction();
			// player action
			if (userAction == "attack") {
				hitTarget = player.gun.fire();
				if (hitTarget) {
					enemy.changeHealthBy(-1 * player.gun.damage());
					if (enemy.isDead()) {
						ui.enemyDefeat();
						return;
					}
				}
			}
			else if (userAction == "escape") {
				if (player.escapeSucceeded()) {
					player.changePositionBy(-1);
					return;
				}
			}
			// enemy action
			hitTarget = enemy.gun.fire();
			if (hitTarget) {
				player.changeHealthBy(-1 * enemy.gun.damage());
				if (player.isDead()) {
					gameOver();
				}
			}
		}
	}
	
	/**
	 * Use UI method {@link getGunChoice} to prompt user to select a gun
	 * then create a gun object based on String of what user chose
	 * @return gun object created
	 */
	public Gun pickGun() {
		Gun gun;
		String gunName = ui.getGunChoice();
		if (gunName == "pistol") {
			gun = new Pistol();
		}
		else if (gunName == "rifle") {
			gun = new Rifle();
		}
		else {
			gun = new Shotgun();
		}
		return gun;
	}
	
	/**
	 * Randomly pick a gun
	 * @return the gun object
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
	 * System sleep for given amount of time
	 * @param time The amount of time (in milliseconds) to sleep for
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
