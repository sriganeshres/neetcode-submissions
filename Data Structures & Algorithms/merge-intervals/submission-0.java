class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ls = new ArrayList<>();
        ls.add(intervals[0]);
        for(int[] i: intervals) {
            int start = i[0];
            int end = i[1];
            int last = ls.get(ls.size() - 1)[1];
            if(start <= last) {
                ls.get(ls.size() - 1)[1] = Math.max(last, end);
            } else {
                ls.add(new int[]{start, end});
            }
        }

        return ls.toArray(new int[ls.size()][]);
    }
}
