class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        Map<Character, Integer> mp = new HashMap<>();
        int l = 0, maxf = 0;
        for(int r = 0; r < s.length(); r++) {
            char x = s.charAt(r);
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            maxf = Math.max(mp.get(x), maxf);
            while((r-l+1) - maxf > k) {
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
