package medium;

import java.util.Arrays;

public class RotateArray {
  // Solution 1
  static int[] solution(int[] nums, int k) {

    // Will give us the remainder in case K is greater than length of nums as when
    // is the same length the array finish as the orignal state
    k = k % nums.length;

    // Time complexity = O(k * n)
    // Space complexity = O(1)
    while (k > 0) {

      int lastValue = nums[nums.length - 1];
      for (int i = nums.length - 1; i > 0; i--) {
        nums[i] = nums[i - 1];
      }
      nums[0] = lastValue;
      k--;
    }

    return nums;
  }

  // Time complexity: O(n)
  // Space complexity: O(1)

  static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  // divide by blocks, the first block is from 0 to k - 1, and the second
  // block is from k to length - 1; once identifying the blocks we can
  // reverse all the array, and reverse each of the block individually, that way
  // we will obtain the result.
  static int[] solution2(int[] nums, int k) {

    k = k % nums.length;

    // Reverse everything
    reverse(nums, 0, nums.length - 1);

    // Reverse the block that was "shifted" to the beggining
    reverse(nums, 0, k - 1);

    // Reverse the block that was shifted to the end
    reverse(nums, k, nums.length - 1);
    return nums;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution2(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 8)));
  }
}

// loop k times
// lastValue = nums[nums.length - 1]
// loop moves everything to the right staring at index 1 nums.length
// nums[i] = nums[i-1]

// lastValue = 7
// temp =
// [1,2,3,4,5,6,7] -> [7,1,2,3,4,5,6]
// |