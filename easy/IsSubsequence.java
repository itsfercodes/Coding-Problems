package easy;

public class IsSubsequence {
  // Time complexity: O(t)
  // Space complexity: O(1)
  public boolean isSubsequence(String s, String t) {

    int pointerS = 0;
    int pointerT = 0;

    while (pointerS < s.length() && pointerT < t.length()) {
      if (s.charAt(pointerS) == t.charAt(pointerT)) {
        pointerS++;
        pointerT++;
      } else {
        pointerT++;
      }
    }

    return pointerS == s.length();
  }
}
