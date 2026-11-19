class Solution {
public:
    int countSubstrings(string s) {
        if(s.length() == 0 || s.length() == 1) return s.length();
        int n = s.size();
        int res = 0;
        for(int i = 0; i < n; i++) {
            int l = i, r = i;
            while(l >= 0 && r < n && s[l] == s[r]) {
                l--;
                r++;
                res++;
            }
            l = i;
            r = i + 1;
            while(l >= 0 && r < n && s[l] == s[r]) {
                l--;
                r++;
                res++;
            }
        }

        return res;
    }
};
