/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        Collections.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        List<Interval> ls = new ArrayList<>();
        ls.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            int last = ls.get(ls.size() - 1).end;
            if(start >= last) {
                ls.add(new Interval(start, end));
            } else {
                return false;
            }
        }

        return true;
    }
}
