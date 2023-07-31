package easy;

public class CanPlaceFlowers {

  // Time complexity: O(n)
  // Space complexity: O(1)
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int leftPointer = 0;
    int rightPointer = 0;
    int i = 0;
    boolean windowAvailable = false;

    // Egde case (when array has length 1)
    if (flowerbed.length == 1) {
      if (flowerbed[0] == 0 && n > 0 || n == 0)
        return true;
      return false;
    }

    // Edge case (when flowers can be placed at the begginnig or end of the array)
    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
      flowerbed[0] = 1;
      n--;
    }

    if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
      flowerbed[flowerbed.length - 1] = 1;
      n--;
    }

    while (i < flowerbed.length) {
      if (flowerbed[i] == 0 && !windowAvailable) {
        leftPointer = i;
        rightPointer = i;
        windowAvailable = true;
      } else if (flowerbed[i] == 0) {
        rightPointer = i;
      } else {
        int bedLength = rightPointer - leftPointer + 1;
        leftPointer = i;
        rightPointer = i;

        if (bedLength % 2 != 1) {
          bedLength -= 1;
        }
        n -= bedLength / 2;
        windowAvailable = false;
      }
      i++;
    }
    if (n <= 0) {
      return true;
    }
    return false;
  }

  // SOlution 2
  public boolean canPlaceFlowers2(int[] flowerbed, int n) {

    if (n == 0)
      return true;

    for (int i = 0; i < flowerbed.length; i++) {
      // Edge cases: when the index is the last checks that the previous is 0, and
      // when the index is 0 checks that the next one is 0
      if (flowerbed[i] == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)
          && (i == 0 || flowerbed[i - 1] == 0)) {
        flowerbed[i] = 1;
        n--;
        if (n == 0)
          return true;
      }

    }
    return false;
  }
}
