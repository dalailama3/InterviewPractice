import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main (String[] args) {
    String[] strings = {"abcabcbb","rkgnejwfe", "qwdewgrehtrjw"};
    for (String str : strings) {
      System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));

    }
  }
  public static int lengthOfLongestSubstring(String s) {
    Map<String,Integer> lastSeenOccurrence = new HashMap<>();
    int start = 0;
    int greatestLength = 0;
    for (int i = 0; i < s.length(); i++) {
      Integer dupIdx = lastSeenOccurrence.put(Character.toString(s.charAt(i)),i);
      // dupIdx will be null if character was not already in the Map
      // if it was in the map then dupIdx gets assigned the last value of the character
      // map will be updated with new index
      if (dupIdx != null) {
        if (dupIdx >= start) {
          // we found a duplicate so compute the greatest length up to this index
          //start will be updated to be last seen occurrence of the character plus 1
          greatestLength = Math.max(greatestLength, i - start);
          start = dupIdx + 1;
        }
      }
    }
    // if there are no duplicates in the entire string then greatestLength is length of the string
    return Math.max(greatestLength,s.length() - start);
  }
}
