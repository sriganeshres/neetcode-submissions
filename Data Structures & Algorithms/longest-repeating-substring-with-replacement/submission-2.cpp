class Solution {
public:
    int characterReplacement(string s, int k) {
        int l = 0, maxf = 0, res = 0;
        map<char, int> mp;
        for (int r = 0; r < s.length(); r++) {
            mp[s[r]]++;
            maxf = max(maxf, mp[s[r]]);
            while((r-l+1) - maxf > k) {
                mp[s[l]]--;
                l++;
            }
            res = max(r-l+1, res);
        }

        return res;
    }
};
