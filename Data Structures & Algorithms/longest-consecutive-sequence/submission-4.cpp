class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        set<int> s(nums.begin(), nums.end());
        int ans = 0;
        for(int xs: s) {
           if(s.find(xs-1) == s.end()) {
                int l = 1;
                while(s.find(xs + l) != s.end()) {
                    l++;
                }
                ans = max(ans, l);
           }
        }

        return ans;
    }
};
