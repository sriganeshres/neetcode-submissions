class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        int res = 0;
        int preEnd = intervals[0][1];
        for(int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] >= preEnd) {
                preEnd = intervals[i][1];
            }
            else {
                preEnd = min(intervals[i][1], preEnd);
                res++;
            }
        }

        return res;
    }
};
