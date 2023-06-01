package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

  // Time Complexity: O(n)
  // Space Complexity: O(n)
  public static boolean Solution(int[] nums) {
    Set<Integer> lookup = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {

      if (lookup.contains(nums[i])) {
        return true;
      }
      lookup.add(nums[i]);

    }

    return false;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 2, 3, 1 };
    System.out.println(Solution(nums));
  }
}
