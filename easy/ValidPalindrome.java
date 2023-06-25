package easy;

public class ValidPalindrome {

  // Other solution is making a new string reading from right to left eliminating
  // all the non alphanumeric characters and then copy the string reversed an
  // compare
  // Time O(2n), Space O(n)

  // Time complexity: O(n)
  // Space complexity: O(1)
  public boolean isPalindrome(String s) {

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      char rightChar = s.charAt(right);
      char leftChar = s.charAt(left);

      if (!Character.isLetterOrDigit(leftChar)) {
        left++;
        continue;
      }

      if (!Character.isLetterOrDigit(rightChar)) {
        right--;
        continue;
      }

      if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }
}
