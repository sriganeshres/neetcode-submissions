class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return new ArrayList(res);
    }

    public void dfs(int[] nums, int i, List<Integer> subset, Set<List<Integer>> res) {
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, res);
    }
}
