import java.util.*;
public class StringPractice {
    //Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
    //Example 1:
    //
    //Input: s = "abcabc", k = 3
    //Output: ["abc", "bca", "cab"]
    //Example 2:
    //
    //Input: s = "abacab", k = 3
    //Output: ["bac", "cab"]
    public static List<String> kDistinct(String str, int k) {
        // I will keep a sliding window, a distinct count, and a char array to keep track of counts of letters seen so far
        // hash set will store unique substrings
        HashSet<String> set = new HashSet<>();
        int distinctChars = 0;
        int i = 0;

        char[] charCounts = new char[26];
        for (; i < k; ++i) {
            // if count is 0, that means character has not been seen yet and is distinct
            if (charCounts[str.charAt(i) - 'a'] == 0) {
                distinctChars++;
            }
            charCounts[str.charAt(i) - 'a']++;

        }
        System.out.println("i: " + i);
        System.out.println("distinct chars: " + distinctChars);
        // at this point, i = k, window is str.substring(i-k,k)
        for (;i < str.length(); ++i) {
            if (distinctChars == k) {
                set.add(str.substring(i-k,i));
            }
            // move the window over, remove beginning of last window from charCounts
            charCounts[str.charAt(i-k) - 'a'] -= 1;
            if (charCounts[str.charAt(i-k) - 'a'] == 0) distinctChars--;
            if (charCounts[str.charAt(i) - 'a'] == 0) {
                distinctChars++;
            }
            charCounts[str.charAt(i) - 'a']++;

        }
        return new ArrayList<String>(set);


    }





    public static void main (String[] args) {
        String[] strings = new String[] {"abcabc", "abacab","awaglknagawunagwkwagl"};
        int[] kVals = new int[] {3,3,4};
        int i = 0;
        for (String s : strings) {
            System.out.println(kDistinct(s,kVals[i++]));

        }

    }
}