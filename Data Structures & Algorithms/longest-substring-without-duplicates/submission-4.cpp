class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() == 0) return 0;
        int res = 1;
        int l = 0, r = 0;
        set<char> st;
        while(r < s.size()) {
            if (st.find(s[r]) == st.end()) {
                res = max(res, r - l + 1);
                st.insert(s[r]);
                r++;
            } else {
                while(st.find(s[r]) != st.end() && l <= r) {
                    st.erase(s[l]);
                    l++;
                }
            }
        } 

        return res;
    }
};
