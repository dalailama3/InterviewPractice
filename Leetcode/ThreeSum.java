
import java.util.*;
public class ThreeSum {
    public static List<List<Integer>> threeSum (int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //System.out.println(nums[i]);
            if (!seen.contains(nums[i])) {
                int [] cp = Arrays.copyOf(nums);
                List<List<Integer>> res = TwoSum.twoSum(nums, target - nums[i]);
                if (res.size() > 0) {
                    for (List<Integer> twoSum : res) {
                        System.out.println("num is: " + curr + " twoSum: " + twoSum);
                        twoSum.add(curr);
                        System.out.println(twoSum);

                    }
                    result.addAll(res);
                    seen.add(nums[i]);


                }
            }


        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1,6,3,7,4,15};
        System.out.println(threeSum(nums, 10));
    }
}
