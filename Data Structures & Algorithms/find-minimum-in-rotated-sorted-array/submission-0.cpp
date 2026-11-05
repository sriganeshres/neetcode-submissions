class Solution {
public:
    int findMin(vector<int> &nums) {
        int l = 0, r = nums.size() - 1;
        int minVal = INT_MAX;
        while(l <= r) {
            int mid = l + (r-l)/2;
            minVal = min(minVal, nums[mid]);
            if(nums[mid] > nums[r]) l = mid + 1;
            else r = mid - 1;
        }
        return minVal;
    }
};
