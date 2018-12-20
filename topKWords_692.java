import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       Map<String, Integer> count = new HashMap<>();
       for(String word : words) {
           count.put(word, count.getOrDefault(word, 0) + 1);
       } 
       PriorityQueue<String> heap = new PriorityQueue<>(
           (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2)
       );
       for(String s : count.keySet()) {
           heap.add(s);
           if(heap.size() > k)
               heap.poll();
       }
       List<String> res = new ArrayList<>();
       while(!heap.isEmpty()) {
           res.add(heap.poll());
       }
       Collections.reverse(res);
       return res;
    }
}