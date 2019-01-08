import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        for(int n : count.keySet()) {
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }

        List<Integer> res = new LinkedList<>();
        while(!heap.isEmpty()) 
            res.add(heap.poll());
        Collections.reverse(res);
        return res;
    }
}