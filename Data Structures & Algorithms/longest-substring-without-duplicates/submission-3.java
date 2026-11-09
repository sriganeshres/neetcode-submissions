class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> mp = new HashSet<>();
        int l = 0;
        int maxS = 0;
        for (int r = 0; r < s.length(); r++) {
            while (mp.contains(s.charAt(r))) {
                mp.remove(s.charAt(l));
                l++;
            }
            mp.add(s.charAt(r));
            maxS = Math.max(maxS, r - l + 1);
        }
        return maxS;
    }
}
