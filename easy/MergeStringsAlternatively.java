package easy;

public class MergeStringsAlternatively {
  // Time complexity: O(n)
  // Space complexity: O(word1 + word2)
  public String mergeAlternately(String word1, String word2) {
    int max = -1;
    int length1 = word1.length() - 1;
    int length2 = word2.length() - 1;

    StringBuilder result = new StringBuilder();

    max = Math.max(word1.length(), word2.length());

    for (int i = 0; i < max; i++) {
      if (i <= length1)
        result.append(word1.charAt(i));
      if (i <= length2)
        result.append(word2.charAt(i));
    }

    return result.toString();
  }
}
