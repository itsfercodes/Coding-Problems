package medium;

import java.util.*;

public class GroupAnagrams {

  static List<List<String>> solution(String[] strs) {
    List<List<String>> result = new ArrayList<>();

    if (strs.length == 0)
      return result;

    // The key is an array of the mapping of the word that encouters with a
    // different pattern, and the
    // value will be the list of anagrams with that pattern
    HashMap<String, List<String>> map = new HashMap<>();

    for (String word : strs) {
      // hash is an array that counts the number of times a letter is repeated. It is
      // length 26 as each position represents one letter from a to z
      int[] hash = new int[26];

      for (char currentChar : word.toCharArray()) {

        // Substracting the value of the current character from 'a' will give us the
        // postion of the character in the array. For example, if a ascii value is 100,
        // and current character is b with an ascii value of 101, then the position in
        // the array of b is 1 as 101-100 = 1. And it adds 1 in the position 1 to mark
        // that letter as it is counted
        hash[currentChar - 'a']++;
      }

      // Converts all the array into a string, example"[0, 1, 1, 0, ... ,1]"
      String key = new String(Arrays.toString(hash));
      // If the key is absent, then put it in the hashmap
      map.computeIfAbsent(key, k -> new ArrayList<>());
      map.get(key).add(word);

    }
    result.addAll(map.values());
    return result;
  }

  public static void main(String[] args) {
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    System.out.println(solution(strs));
  }

}
