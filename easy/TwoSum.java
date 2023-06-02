package easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  static int[] Solution(int[] nums, int target) {

    Map<Integer, Integer> lookup = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complementary = target - nums[i];

      if (lookup.containsKey(complementary))
        return new int[] { i, lookup.get(complementary) };

      lookup.put(nums[i], i);
    }
    return new int[] {};
  }

  public static void main(String[] args) {
    int[] x = Solution(new int[] { 2, 7, 11, 15 }, 9);
    System.out.println(Arrays.toString(x));
  }
}
