package crackinginterview.chapter1;

import java.util.*;

/* Given a string,write a function to check if it is a permutation of a palindrome. 
A palindrome is a word or phrase that is the same forwards and backwards.A permutation 
is a rearrangement of letters.The palindrome does not need to be limited to just dictionary
words.You can ignore casing and non-letter characters */
public class PalindromePermutation {

  // Time complexity: O(n)
  // Space complexity: O(n)
  static boolean solution(String str) {

    HashMap<Character, Integer> lookup = new HashMap<>();
    boolean oddFound = false;

    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);
      if (lookup.containsKey(currentChar)) {
        lookup.put(currentChar, lookup.get(currentChar) + 1);
      } else {
        lookup.put(currentChar, 1);
      }
    }

    for (int currentValue : lookup.values()) {
      if (currentValue % 2 == 1 && oddFound)
        return false;
      if (currentValue % 2 == 1)
        oddFound = true;

    }

    return true;
  }

  // Time complexity: O(n log n)
  // Space complexity: O(1)
  // Soution would be sorting the string and with a sliding window check that the
  // characters inside the window are the same and are even count, if we find more
  // that one odd character then return false

  public static void main(String[] args) {
    System.out.println(solution("aabbcdcbbaa"));
    System.out.println(solution("aabbcdecbbaa"));
  }
}

// abcba -> bbaac <-- Permutation of palimdrome
// aabbcdcbbaa -> aaaabbbbccde{a: 4, b: 4, c: 2, d: 1, e: 1}
