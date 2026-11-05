class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<int[]> ls = new ArrayList<>();
        ls.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int last = ls.get(ls.size() - 1)[1];
            if(start >= last) {
                ls.add(new int[]{start, end});
            } else {
                ls.get(ls.size() - 1)[1] = Math.min(last, end);
            }
        }

        return intervals.length - ls.size();
    }
}
