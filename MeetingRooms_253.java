import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length <= 1)
            return intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
           @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
           @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        
        pq.add(intervals[0]);
        for(int i=1;i<intervals.length;i++) {
            Interval val = pq.peek();
            if(intervals[i].start >= val.end)
                pq.poll();
            pq.add(intervals[i]);
        }
        return pq.size();
    }
}