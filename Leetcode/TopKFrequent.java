import java.util.*;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int n : map.keySet()) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> l = new ArrayList<>();
        while(!heap.isEmpty()){
            l.add(heap.poll());
        }

        Collections.reverse(l);
        return l;

    }

}
