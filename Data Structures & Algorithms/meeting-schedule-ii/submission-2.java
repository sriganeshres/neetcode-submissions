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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;
        List<int[]> allTimes = new ArrayList<>();
        for(Interval i: intervals) {
            int start = i.start;
            int end = i.end;
            allTimes.add(new int[]{start, 1});
            allTimes.add(new int[]{end, -1});
        }

        Collections.sort(allTimes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int max = 0, c = 0;
        for(int[] a: allTimes) {
            c += a[1];
            max = Math.max(c, max);
        }

        return max;
    }
}
