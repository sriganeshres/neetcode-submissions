class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0, sum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        for(int n: nums) {
            sum += n;
            answer += prefixSums.getOrDefault(sum - k, 0);
            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }
}