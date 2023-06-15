package crackinginterview.chapter1;

/* Write a method to replace all spaces in a string with "%20". You may assume 
the given string has sufficient space at the end to hold the additional characters, 
and that you are given the "true" length of the string. */
public class URLify {

  // Time complexity: O(n)
  // Space complexity: O(n)
  static String Solution1(char[] str, int trueLentgh) {

    String url = "";

    for (int i = 0; i < trueLentgh; i++) {
      if (str[i] == ' ') {
        url = url.concat("%20");
      } else {
        url = url.concat(String.valueOf(str[i]));
      }
    }

    return url;
  }

  // Time complexity: O(n)
  // Space complexity: O(1)
  // For this we require that the string is converted to char array in order to be
  // manipulated in place
  static String Solution2(char[] str, int trueLength) {
    int actualLengthPointer = str.length - 1;

    // True length will keep track of the position of the last char of the string
    // (without counting the extra spaces)
    for (int trueLengthPointer = trueLength - 1; trueLengthPointer >= 0; trueLengthPointer--) {
      // If there is a space it will override the old characters with the new ones at
      // the actualLengthPointer position, which by that point in the execution would
      // already passed all the characters to positions more to the end of the string
      // meaning that no characters would be lost
      if (str[trueLengthPointer] == ' ') {
        str[actualLengthPointer] = '0';
        str[actualLengthPointer - 1] = '2';
        str[actualLengthPointer - 2] = '%';
        actualLengthPointer -= 3;
      } else {
        str[actualLengthPointer] = str[trueLengthPointer];
        actualLengthPointer--;
      }
    }

    String url = new String(str);
    return url;
  }

  public static void main(String[] args) {
    System.out.println(Solution1("Mr John Smith    ".toCharArray(), 13));
    System.out.println(Solution2("Mr John Smith    ".toCharArray(), 13));
  }
}
