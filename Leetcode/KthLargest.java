import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        for(int n : nums) {
            pq.offer(n);
        }
        int result = 0;
        while(k > 0 && !pq.isEmpty()){
            result = pq.poll();
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
