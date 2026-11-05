class Solution {
public:
    int characterReplacement(string s, int k) {
        map<char, int> ch;
        int i = 0, maxC = 0, res = 0;
        for(int r = 0; r < s.size(); r++) {
            ch[s[r]]++;
            maxC = max(maxC, ch[s[r]]);
            while((r - i + 1) - maxC > k) {
                ch[s[i]]--;
                i++;
            }
            res = max(res, (r - i + 1));
        }
        return res;
    }
};
