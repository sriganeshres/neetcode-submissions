class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int curr = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != curr) {
                nums[k++] = nums[i];
                curr = nums[i];
            }
        }

        return k;
    }
}