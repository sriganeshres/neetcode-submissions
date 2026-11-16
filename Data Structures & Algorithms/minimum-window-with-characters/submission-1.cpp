class Solution {
public:
    string minWindow(string s, string t) {
        int finalL, finalR;
        int minLen = INT_MAX;
        if (s.length() < t.length()) return "";
        int l = 0, req = 0, formed = 0;
        map<char, int> freq1, freq2;
        for(int i = 0; i < t.length(); i++) {
            freq1[t[i]]++;
        }
        req = freq1.size();
        for(int r = 0; r < s.length(); r++) {
            char c = s[r];
            freq2[s[r]]++;
            if (freq1.count(c) && freq2[c] == freq1[c]) {
                formed++;
            }
            while(formed == req) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    finalL = l;
                    finalR = r;
                }
                freq2[s[l]]--;
                if (freq1.count(s[l]) && freq2[s[l]] < freq1[s[l]]) {
                    formed--;
                }
                l++;
            }
        }

        return minLen != INT_MAX ? s.substr(finalL, minLen) : "";
    }
};
