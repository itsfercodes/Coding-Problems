package crackinginterview.chapter1;

/* There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check 
if they are one edit (or zero edits) away. */

public class OneWay {

  static boolean solution(String original, String edited) {
    int editsNumber = 0;
    int originalPointer = 0;
    int editedPointer = 0;

    // Check adds and removals
    editsNumber = Math.abs(original.length() - edited.length());

    if (editsNumber > 1)
      return false;

    return true;
  }

  public static void main(String[] args) {
    System.out.println(solution("pale", "ple"));
    System.out.println(solution("pales", "pale"));
    System.out.println(solution("pale", "bale"));
    System.out.println(solution("pale", "bake"));
  }
}

// |
// palee pal
// |
// if original is finished check if edited was longer and by how many
// characters, then sum that quantity to the editsNumber