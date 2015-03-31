package com.frequency_calculator;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * FrequencyCalculator
 * 
 * @author paul
 * 
 * 
 */
public class FrequencyCalculator {

	public static void main(String[] args) {
		System.out.println("Enter the word(s).Type quit to end");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		while (!word.equals("quit")) {
			if (word != null && !word.isEmpty()) {
				String highestFrequencyLetter = String
						.valueOf(getHighestFrequencyLetter(word));
				if (highestFrequencyLetter.trim().equals("")) {
					highestFrequencyLetter = "none";
				}
				System.out.println("Highest frequency letter is "
						+ highestFrequencyLetter.toLowerCase());
			} else {
				System.out.println("Enter a valid word");
			}
			System.out.println("\nEnter the word(s).Type quit to end");
			word = scanner.nextLine();
		}
		scanner.close();
	}

	/**
	 * gets the letter which occurs most in a given text if 2 or more characters
	 * have the same frequency,it returns the first one
	 * 
	 * @param word
	 * @return highestFrequencyChar
	 */
	public static char getHighestFrequencyLetter(String word) {
		// declare the highest requency char to look for
		char highestFrequencyChar = ' ';
		// hashmap to track counts of chars
		HashMap<Character, Integer> hashMap = new HashMap<>();
		// max count/highest frequency
		int maxCount = 0;
		// get all characters and loop through once
		for (char c : word.toCharArray()) {
			// if it's a letter
			if (String.valueOf(c).matches("[a-zA-Z]")) {
				// count
				int count = 1;
				// if the letter is already present just increment the frequency
				if (hashMap.containsKey(c)) {
					count = hashMap.get(c) + 1;
				}
				// update the frequency
				hashMap.put(c, count);
				// if the count exceeds the max count, update max count
				if (count > maxCount) {
					maxCount = count;
					highestFrequencyChar = c;
				}
			}
		}
		return highestFrequencyChar;
	}
}
