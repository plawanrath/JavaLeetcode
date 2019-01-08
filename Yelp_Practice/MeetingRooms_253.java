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
        if(intervals.length <= 1) {
            return intervals.length;
        }
        Arrays.sort(intervals, new IntervalComparator());
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new IntervalEndComparator());
        pq.add(intervals[0]);
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i].start >= pq.peek().end) {
                pq.poll();
            } 
            pq.add(intervals[i]);
        }
        return pq.size();
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}

class IntervalEndComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return b.end - a.end;
    }
}