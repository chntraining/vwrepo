package com.vw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {

	public static void main(String[] args) {

		List<String> flist = Arrays.asList("apple", "banana", "grapes", "cherry", "orange");
		Set<String> fset = new HashSet<String>(flist);
		Map<String, String> fmap = new HashMap<>();

		fmap.put("apple", "red color fruits used by Newton");
		fmap.put("banana", "long curved yellow color fruit");
		fmap.put("grapes", "small purple color fruit");
		fmap.put("cherry", "small red fruits with small seeds");
		fmap.put("orange", "orange color fruits");

		Scanner scn = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Welcome to game");
		System.out.println("Guess the fruit :)");

		String randomFruit = flist.get(random.nextInt(flist.size()));
		String fruitdef = fmap.get(randomFruit);
		System.out.println("Hint :" + fruitdef);

		boolean hasGuessedCorrectly = false;

		while (!hasGuessedCorrectly) {
			System.out.println("Your Guess:");
			String yourguess = scn.nextLine().toLowerCase();

			if (fset.contains(yourguess)) {
				if (yourguess.equals(randomFruit)) {
					hasGuessedCorrectly = true;
					System.out.println("Wow , You Guess the fruit :)");
				} else {
					System.out.println("Try again?");
				}
			}
			else {
				System.out.println("Not a valid fruit. Try Again");
			}

		}

	}

}
