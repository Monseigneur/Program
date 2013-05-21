/**
 * 
 * @author Milan
 *
 */

public class Util {
  public static char[] intToCharArr(int val) {
    char[] arr = new char[ProgramRunner.WORD_SIZE];
    for (int i = 0; i < arr.length; i++) {
      arr[arr.length - i - 1] = (char)(val % 256);
      val /= 256;
    }
    return arr;
  }
  
  public static int charArrToInt(char[] arr) {
    int val = 0;
    for (int i = 0; i < arr.length; i++) {
      val += ((int)arr[i]) << (arr.length - i - 1);
    }
    return val;
  }
  
  public static void printHex(char[] arr, int start, int end) {
    String hex = "";
    for (int i = start; i < end; i++) {
      String h = Integer.toHexString(arr[i]);
      if (h.length() == 1) {
        h = "0" + h;
      }
      hex += h;
    }
    System.out.println(hex);
  }

}
