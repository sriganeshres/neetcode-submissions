class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(f(cost, 0), f(cost, 1));
    }

    int f(int[] cost, int i) {
        if(i >= cost.length) return 0;
        if(i == cost.length - 1) return cost[i];
        return cost[i] + Math.min(f(cost, i + 1), f(cost, i + 2));
    }
}
