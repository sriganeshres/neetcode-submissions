class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for(int[] i: intervals) {
            for(int j = i[0]; j <= i[1]; j++) {
                hp.put(j, Math.min(hp.getOrDefault(j, Integer.MAX_VALUE), i[1] - i[0] + 1));
            }
        }
        int[] res = new int[queries.length];
        int j = 0;
        for(int i: queries) {
            res[j++] = hp.getOrDefault(i, -1);
        }

        return res;
    }
}
