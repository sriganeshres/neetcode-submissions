class Solution {
    public String reorganizeString(String s) {
        int []count = new int[26];
        for(char c: s.toCharArray())
            count[c - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int []prev = null;
        for(int i = 0; i < 26; i++) {
            if(count[i] > 0)
                pq.offer(new int[]{count[i], i});
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty() || prev != null) {
            if(prev != null && pq.isEmpty()) return "";
            int[] val = pq.poll();
            char c = (char)(val[1] + 'a');
            sb.append(c);
            val[0]--;
            if (prev != null) {
                pq.offer(prev);
                prev = null;
            }
            if (val[0] > 0) {
                prev = val;
            }
        }
        return sb.toString();
    }
}