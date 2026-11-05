class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0, totCost = 0;
        for(int i = 0; i < gas.length; i++) {
            totGas += gas[i];
            totCost += cost[i];
        }

        if(totCost > totGas) return -1;

        int gasAv = 0, start = 0;
        for(int i = 0; i < gas.length; i++) {
            gasAv += (gas[i] - cost[i]);
            if(gasAv < 0) {
                gasAv = 0;
                start = i + 1;
            }
        }

        return start;
    }
}
