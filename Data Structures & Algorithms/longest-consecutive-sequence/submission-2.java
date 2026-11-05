class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int n:nums) st.add(n);
        int longest = 0;
        for(int n: nums) {
            if(!st.contains(n-1)) {
                int longi = 1;
                while(st.contains(longi + n)) longi++;
                longest = Math.max(longest, longi);
            }
        }
        return longest;
    }
}
