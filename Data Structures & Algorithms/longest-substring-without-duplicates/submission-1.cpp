class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        set<char> st;
        int l = 0, r = 0;
        int maxLen = 0;
        while(r < s.length()) {
            while(st.find(s[r]) != st.end()) {
                st.erase(s[l]);
                l++;
            }
            maxLen = max(maxLen, r - l + 1);
            st.insert(s[r]);
            r++;
        }
        return maxLen;
    }
};
