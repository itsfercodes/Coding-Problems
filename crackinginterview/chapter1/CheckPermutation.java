package crackinginterview.chapter1;

import java.util.*;

// Given two strings, write a method to decide if one is a permutation of the other
public class CheckPermutation {

  // Time complexity: O(n log n)
  // Space complexity: O(1)
  static boolean solution1(String word1, String word2) {

    if (word1.length() != word2.length()) {
      return false;
    }

    char[] word1Array = word1.toCharArray();
    char[] word2Array = word2.toCharArray();
    Arrays.sort(word1Array);
    Arrays.sort(word2Array);

    word1 = new String(word1Array);
    word2 = new String(word2Array);

    if (!word1.equals(word2)) {
      return false;
    }

    return true;
  }

  // Time complexity: O(n)
  // Space complexity: O(n)
  // To improve we can use an array[128] and decrement the value of the repeated
  // characters
  static boolean solution2(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    HashMap<Character, Integer> lookup = new HashMap<>();

    for (int i = 0; i < word1.length(); i++) {
      char currentChar = word1.charAt(i);
      if (lookup.containsKey(currentChar)) {
        lookup.put(currentChar, lookup.get(currentChar) + 1);
      } else {
        lookup.put(currentChar, 1);
      }
    }

    for (int i = 0; i < word2.length(); i++) {
      char currentChar = word2.charAt(i);
      if (!lookup.containsKey(currentChar) || lookup.get(currentChar) <= 0) {
        return false;
      }

      lookup.put(currentChar, lookup.get(currentChar) - 1);
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(solution2("letra", "alert"));
    System.out.println(solution2("letra", "alertas"));
  }
}
