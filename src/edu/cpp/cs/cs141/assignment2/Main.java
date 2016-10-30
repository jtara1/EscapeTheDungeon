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
 * Create {@link GameEngine} object and run <i>Escape the Dungeon!</i>
 * @author James Taracevicz
 *
 */
public class Main {
	
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		game.run();
	}
}
