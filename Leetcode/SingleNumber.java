import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    //https://leetcode.com/problems/single-number/
    public int singleNumber(int[] nums) {
        int a=0;
        for(int i=0; i<nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
}

