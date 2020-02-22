import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int n : nums) {


            if (pq.size() == k) {
                if (n > pq.peek()) {
                    pq.poll();
                    pq.offer(n);
                }
            } else {
                pq.offer(n);
            }

            System.out.println(pq);

        }


        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 3));
    }
}
