package easy;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
  // Time complexity O(2n)
  // Space complexity O(n)
  static boolean Solution(String s, String t) {

    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Integer> lookup = new HashMap<>();

    // Register all the characters and the numbers of times they appear in a hashmap
    for (int i = 0; i < s.length(); i++) {
      char currentCharacter = s.charAt(i);
      if (lookup.containsKey(currentCharacter)) {
        lookup.put(currentCharacter, lookup.get(currentCharacter) + 1);
      } else {
        lookup.put(currentCharacter, 1);
      }
    }

    // Traverses the second string comparing the characters with the mapped string
    for (int i = 0; i < t.length(); i++) {
      char currentCharacter = t.charAt(i);
      if (lookup.containsKey(currentCharacter) && lookup.get(currentCharacter) > 0) {
        lookup.put(currentCharacter, lookup.get(currentCharacter) - 1);
      } else {
        return false;
      }
    }

    return true;
  }

  // ===========================================================================================
  // Time complexity: O(2nlogn * n)
  // Space complexity: O(1)
  static Boolean Solution2(String s, String t) {
    if (s.length() != t.length())
      return false;

    char[] charS = s.toCharArray();
    char[] charT = t.toCharArray();

    Arrays.sort(charS);
    Arrays.sort(charT);

    s = new String(charS);
    t = new String(charT);

    if (!s.equals(t))
      return false;

    return true;

  }

  public static void main(String[] args) {
    System.out.println(Solution("anagram", "nagaram"));
    System.out.println(Solution("cat", "rat"));
  }
}
