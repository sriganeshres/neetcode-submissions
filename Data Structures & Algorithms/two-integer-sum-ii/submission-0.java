class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            int diff = target-numbers[i];
            if(map.containsKey(diff) == true) {
                int val = map.get(diff);
                return new int[]{val + 1, i + 1};
            } else {
                map.put(numbers[i], i);
            }
        }

        return new int[]{0, 0};
    }
}
