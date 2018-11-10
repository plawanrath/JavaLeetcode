import java.util.*;

public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(final Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Stack<Interval> res = new Stack<>();
        res.push(intervals.get(0));
        int index = 1;
        while(index < intervals.size()) {
            Interval val = res.peek();
            if(val.end < intervals.get(index).start) {
                res.push(intervals.get(index));
            } else {
                Interval remove = res.pop();
                Interval newInt = new Interval(remove.start, Math.max(remove.end, intervals.get(index).end));
                res.push(newInt);
            }
            index++;
        }
        return res;
    }
}