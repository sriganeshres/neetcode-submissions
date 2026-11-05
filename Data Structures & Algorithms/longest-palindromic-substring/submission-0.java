class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int res = 0, len = 0;
        for(int i = 0; i < n; i++) {
            int l = i, r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > len) {
                    len = r - l + 1;
                    res = l;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > len) {
                    len = r - l + 1;
                    res = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(res, res + len);

    }
}
