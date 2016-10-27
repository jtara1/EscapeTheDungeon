package edu.cpp.cs.cs141.assignment2;

public class Main {
	
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		game.run();
//		testFormatting();
//		testThings();
	}
	
	public static void testFormatting() {
		System.out.printf(
				"Tile you're on: %d\n" +
				"Player Stats:%15sEnemy Stats:\n" +
				"HP: %0d%22sHP: %0d\n" +
				"Gun: %s%17sGun: %s\n" +
				"Accuracy: %.2f%3sChance to hit player: %.2f\n" +
				"Damage: %d%19sDamage: %s\n",
				5,
				"",
				19, "", 4,
				"Pistol", "", "Shotgun",
				0.75, "", 0.40,
				1, "", 5);
		
		String myStr = "Player Stats:               Enemy Stats:";
		String myStr2 = "Player Stats:               ";
		System.out.println(myStr.length());
		System.out.println(myStr2.length());
	}
	
	public static void testThings() {
		ItemDrop item = new MedKit();
		System.out.println(item.getClass());
//		if ((String)item.getClass() == "MedKit") {
//			System.out.println("yes");
//		}
		String[] array = testThings2();
		for (String s: array) {
			System.out.println(s);
		}
		
	}
	
	public static String[] testThings2() {
		String[] str = {"hello", "world"};
		return str;
	}
}
