// Find the first and last occurence of an element in a sorted array
//
import java.util.*;

public class FirstAndLastOccurrence {
  public static int[] searchRange(int[] nums, int target) {
      int[] result = new int[2];
      result[0] = findFirst(nums,target);
      result[1] = findLast(nums,target);
      return result;
  }

  public static int findFirst(int[] nums, int target) {
      int result = -1;
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
          // System.out.println("left: " + left);
          // System.out.println("right: " + right);
          int mid = left + (right - left)/2;
          if (nums[mid] == target) {
              result = mid;
              // go left even more
              right = mid - 1;
          } else if (nums[mid] < target) {
              left = mid + 1;
          } else if (nums[mid] > target) {
              right = mid - 1;
          }
      }
      return result;
  }
  public static int findLast(int[] nums, int target) {
      int result = -1;
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
          //System.out.println("left: " + left);
          //System.out.println("right: " + right);
          int mid = left + (right - left)/2;
          if (nums[mid] == target) {
              result = mid;
              // go right even more
              left = mid + 1;
          } else if (nums[mid] < target) {
              left = mid + 1;
          } else if (nums[mid] > target) {
              right = mid - 1;
          }
      }
      return result;
  }
}
