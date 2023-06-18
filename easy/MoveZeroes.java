package easy;

import java.util.Arrays;

public class MoveZeroes {

  // Time complexity: O(n)
  // Space complexity: O(n)
  static int[] solution(int[] nums) {
    int zeroCount = 0;
    int indexResult = 0;
    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroCount++;
      } else {
        result[indexResult] = nums[i];
        indexResult++;
      }
    }

    for (int i = indexResult; i < result.length; i++) {
      result[i] = 0;
    }

    return result;

  }

  // Time complexity: O(n)
  // Space complexity: O(1)
  // We approach it moving non zeroes to the left, instead of moving zeroes to the
  // right, left pointer will left behind all the values that are already moved to
  // the left which are already "sorted", and when a non zero is found the
  // position at the pointer will be replaced with the value found and the
  // position of the value found will be 0
  static int[] solution2(int[] nums) {
    int leftPointer = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[leftPointer];
        nums[leftPointer] = temp;
        leftPointer++;
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution2(new int[] { 1, 0, 3, 0, 6, 0 })));
  }

}
// p
// c
// [1,3,6,0,0,0] -> [1,3,6,0,0,0]
// leftPointer = 3