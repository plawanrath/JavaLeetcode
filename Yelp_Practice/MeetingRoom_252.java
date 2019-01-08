import java.util.Arrays;
import java.util.Comparator;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new IntervalComparator());
        Interval curr = intervals[0];
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i].start < curr.end) {
                return false;
            }
            curr = intervals[i];
        }
        return true;
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}