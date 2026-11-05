class Solution {
public:
    unordered_set<string> st;
    vector<int> dp;
    int maxL = 0;
    bool wordBreak(string s, vector<string>& wordDict) {
        st.insert(wordDict.begin(), wordDict.end());
        dp.resize(s.length(), -1);
        for(string w: wordDict) maxL = max(maxL, int(w.length()));
        return f(0, s);
    }

    bool f(int i, string& s) {
        if(i == s.length()) return true;
        if(dp[i] != -1) return dp[i] == 1;
        for(int j = i; j < min(i + maxL, int(s.length())); j++) {
            if(st.count(s.substr(i, j - i + 1))) {
                if(f(j + 1, s)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = 0;
        return false;
    }
};
