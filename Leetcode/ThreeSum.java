
import java.util.*;
public class ThreeSum {
    public static List<List<Integer>> threeSum (int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> res = TwoSum.twoSum(nums,target - nums[i]);
            if (res.size() > 0) {
                for (List<Integer> twoSum : res) {
                    twoSum.add(nums[i]);
                    result.add(twoSum);
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1,6,3-7,4,15};
        System.out.println(threeSum(nums, 10));
    }
}
