import java.util.*;
/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.
https://leetcode.com/problems/longest-consecutive-sequence/
*/
public class LongestConsecutiveSequence {
  public static void main (String[] args) {
    int[] arr = {4,200,1,3,2};
    System.out.println(longestConsecutive(arr));

  }

  public static int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int longest = 0;
    for (int num : nums) {
      set.add(num);
    }
    for (int num : nums) {
      // find e + 1, + 2...
      int count = 0;
      if (set.contains(num)) {
        set.remove(num);
        count = 1;
        int above = num + 1;
        while (set.contains(above)) {
          set.remove(above);
          count++;
          above++;
        }
        int below = num - 1;
        // find e-1,e-2...
        while (set.contains(below)) {
          set.remove(below);
          count++;
          below--;
        }
      }
      longest = Math.max(longest,count);
    }
    return longest;
  }
}
