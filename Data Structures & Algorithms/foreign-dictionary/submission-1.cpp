class Solution {
public:
    string foreignDictionary(vector<string>& words) {
        unordered_map<char, set<char>> mp;
        unordered_map<char, int> indeg;
        int n = words.size();
        for (const auto& word : words) {
            for (char ch : word) {
                mp[ch];
                indeg[ch] = 0;
            }
        }
        for(int i = 0; i < n - 1; i++) {
            string w1 = words[i], w2 = words[i+1];

            int minLen = min(w1.length(), w2.length());
            if (w1.length() > w2.length() &&
                w1.substr(0, minLen) == w2.substr(0, minLen)) {
                return "";
            }
            for (int j = 0; j < minLen; ++j) {
                if (w1[j] != w2[j]) {
                    if (!mp[w1[j]].count(w2[j])) {
                        mp[w1[j]].insert(w2[j]);
                        indeg[w2[j]]++;
                    }
                    break;
                }
            }
        }

        queue<char> q;
        for (auto &[c, deg] : indeg) {
            if (deg == 0) {
                q.push(c);
            }
        }
        string res = "";
        while(!q.empty()) {
            char c = q.front();
            q.pop();
            res += c;
            for (char neighbor : mp[c]) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) {
                    q.push(neighbor);
                }
            }
        }

        return res.size() == indeg.size() ? res : "";
    }
};
