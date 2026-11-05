class Solution {
public:
    vector<vector<int>> answer;
    vector<int> res;
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        f(target, nums, 0);
        return answer;
    }
    void f(int target, vector<int>& nums, int i) {
        if(target == 0) {
            answer.push_back(res);
            return;
        }
        if(target < 0 || i >= nums.size()) return;
        res.push_back(nums[i]);
        f(target - nums[i], nums, i);

        // f(target - nums[i], nums, i + 1);

        res.pop_back();
        f(target, nums, i + 1);
    }

};
