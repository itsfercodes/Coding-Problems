package crackinginterview.chapter1;

import java.util.*;

// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures
public class IsUnique {

  // Time complexity: O(n)
  // Space can be reduced to O(1) if we know the characters set size, so we create
  // a boolean array of the size of the char set and convert the characters to int
  // values (ascii code). If the position is false we can mark it as true, if it
  // is true then we return true as it is repeated
  // Space complexity: O(n)
  static boolean Solution1(String str) {

    char[] characters = str.toCharArray();
    HashMap<Character, Integer> lookup = new HashMap<>();

    for (char currentChar : characters) {
      if (lookup.containsKey(currentChar)) {
        return true;
      }
      lookup.put(currentChar, 1);
    }
    return false;
  }

  // Time complexity: O(nlogn * n)
  // Space complexity: O(1)
  static boolean Solution2(String str) {

    char[] characters = str.toCharArray();
    Arrays.sort(characters);

    for (int i = 0; i < characters.length - 1; i++) {
      if (characters[i] == characters[i + 1]) {
        return true;
      }
    }
    return false;

  }

  public static void main(String[] args) {
    System.out.println(Solution1("murcielago"));
    System.out.println(Solution1("monitor"));

    // ===============================================
    System.out.println(Solution2("murcielago"));
    System.out.println(Solution2("monitor"));
  }
}
