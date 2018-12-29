import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c : tasks)
            map[c - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder()); //Max-Heap
        for(int f : map) {
            if(f > 0)
                pq.add(f);
        }
        int time = 0;
        while(!pq.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while(i <= n) {
                if(!pq.isEmpty()) {
                    if(pq.peek() > 1)
                        temp.add(pq.poll() - 1);
                    else
                        pq.poll();
                }
                time++;
                if(pq.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for(int l : temp)
                pq.add(l);
        }
        return time;
    }
}