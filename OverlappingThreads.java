/**
 * Given a list of threads with a start time and finish time, 
 * determine all the threads with overlapping times .
 * Threads = [[1, 4], [2, 5], [5, 7]]
 * Answer = 2
 */

import java.util.*;
class Interval {
    int start, end;
    public Interval(int s, int e) { start = s; end = e; }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}

class Solution {
    public int OverlappingThreads(int[][] threads) {
        List<Interval> threadIntervals = new ArrayList<>();
        for(int[] thread : threads)
            threadIntervals.add(new Interval(thread[0], thread[1]));
        threadIntervals.sort(new IntervalComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(threadIntervals.get(0).end);
        for(int i=1;i<threadIntervals.size();i++) {
            Interval val = threadIntervals.get(i);
            if(pq.peek() <= val.start) {
                pq.poll();
            }
            pq.add(val.end);            
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] threads = {{1, 4}, {2, 5}, {3, 4}, {5, 7}};
        System.out.println(s.OverlappingThreads(threads));
    }
}