class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(0, nums, res);
        return res;
    }

    public void back(int i, int[] nums, List<List<Integer>> res) {
        if(i == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for(int n:nums) perm.add(n);
            res.add(perm);
            return;
        }
        for(int idx = i; idx < nums.length; idx++) {
            swap(nums, i, idx);
            back(i + 1, nums, res);
            swap(nums, i, idx);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
