class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList();
        dfs(0, target, ls, nums, res);
        return res;
    }

    public void dfs(int i, int target, List<Integer> ls, int[] nums, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        if(target < 0 || i >= nums.length) return;
        ls.add(nums[i]);
        dfs(i, target-nums[i], ls, nums, res);
        ls.remove(ls.size() - 1);
        dfs(i + 1, target, ls, nums, res);
    }
}
