class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> mp;
        for(string& st: strs) {
            string sortedS = st;
            sort(sortedS.begin(), sortedS.end());
            mp[sortedS].push_back(st);
        }

        vector<vector<string>> ans;
        for(auto p: mp) {
            ans.push_back(p.second);
        }

        return ans;
    }
};
