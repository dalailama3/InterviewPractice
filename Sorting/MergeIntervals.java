import java.util.*;
public class MergeIntervals {
//Given a collection of intervals, merge all overlapping intervals.
//https://leetcode.com/problems/merge-intervals/

    public static void main (String[] args) {
      int[][] intervals = {{1,2},{3,5},{6,8},{0,10}};
      int[][] merged = merge(intervals);
      for (int[] interval : merged) {
        System.out.println(Arrays.toString(interval));
      }
    }

    public static int[][] merge(int[][] intervals) {
      //sort the array and then iterate though each interval.  compare each interval to last element written to result.

      int[][] result = new int[intervals.length][2];
      Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
      if (intervals.length == 0) return result;

      int writeIdx = 1;
      result[0] = intervals[0];
      for (int i = 1; i < intervals.length; i++) {
        int[] interval = intervals[i];
        // check if previous written element's endpoint is less than current interval's startpoint
        if (result[writeIdx-1][1] < interval[0]) {
          result[writeIdx++] = interval;
        } else {
            int[] mergedArray = { Math.min(result[writeIdx-1][0],interval[0]), Math.max(result[writeIdx-1][1],interval[1])};
            result[writeIdx-1] = mergedArray;
        }

      }
      return Arrays.copyOfRange(result,0,writeIdx);

    }




}
