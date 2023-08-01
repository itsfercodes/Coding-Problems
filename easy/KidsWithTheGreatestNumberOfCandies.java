package easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

  // Time complexity O(n)
  // Space complexity O(n)
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    ArrayList<Boolean> result = new ArrayList<>();

    int maxNumber = -1;
    for (int candiesNumber : candies) {
      if (candiesNumber > maxNumber) {
        maxNumber = candiesNumber;
      }
    }

    for (int i = 0; i < candies.length; i++) {
      if (candies[i] + extraCandies >= maxNumber) {
        result.add(true);
      } else {
        result.add(false);
      }

    }

    return result;
  }
}
