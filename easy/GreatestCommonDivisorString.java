package easy;

public class GreatestCommonDivisorString {
  static boolean isDivisible(String str1, String str2, String substring) {
    int length1 = str1.length();
    int length2 = str2.length();
    int lengthS = substring.length();

    if (length1 % lengthS > 0 && length2 % lengthS > 0)
      return false;

    String s1 = substring.repeat(length1 / lengthS);
    String s2 = substring.repeat(length2 / lengthS);

    return s1.equals(str1) && s2.equals(str2);

  }

  public static String gcdOfStrings(String str1, String str2) {

    int length1 = str1.length();
    int length2 = str2.length();

    for (int i = Math.min(length1, length2); i > 0; i--) {
      String currentSubstring = str1.substring(0, i);
      if (isDivisible(str1, str2, currentSubstring))
        return currentSubstring;
    }

    return "";

  }

  public static void main(String[] args) {
    System.out.println(gcdOfStrings("ABCABC", "ABC"));
    System.out.println(gcdOfStrings("ABABAB", "AB"));
    System.out.println(gcdOfStrings("LEET", "CODE"));
  }
}
