import java.util.*;
public class TwoSum {
    public static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int i = 0;
        int j = nums.length -1;
        while (i <= j) {
            if (nums[i] + nums[j] == target) {
                if (result.size() == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                } else {
                    if (nums[i] != result.get(result.size()-1).get(0)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        result.add(list);
                    }
                }
                i++;
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j --;
            }
        }
        return result;
    }



    public static void main (String[] args) {
        int[] nums = {4,4,1,6,3,9,0,-4};
        System.out.println(twoSum(nums,9));
    }

}