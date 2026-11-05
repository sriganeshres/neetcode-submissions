class Solution {
    public int[] productExceptSelf(int[] nums) {
        int full = 1;
        boolean aZero = false, mulZero = false;
        for(int n: nums) {
            if(n != 0) full *= n;
            else if(!aZero) aZero = true;
            else if(aZero) mulZero = true; 
        }
        int[] ans = new int[nums.length];
        if(mulZero) return ans;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)  {
                if(!aZero) ans[i] = full / nums[i];
                else ans[i] = 0;
            }
            else ans[i] = full;
        }
        return ans;
    }
}  
