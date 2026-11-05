class Solution {
    public int maxProduct(int[] nums) {
        int curMin = 1, curMax = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res) res = nums[i];
        }
        for(int n: nums) {
            int temp = curMax * n;
            curMax = Math.max(Math.max(n * curMax, n * curMin), n);
            curMin = Math.min(Math.min(temp, n * curMin), n);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
