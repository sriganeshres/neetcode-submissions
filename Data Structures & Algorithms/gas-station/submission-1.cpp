class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int totgas = accumulate(gas.begin(), gas.end(), 0);
        int totcost = accumulate(cost.begin(), cost.end(), 0);
        if(totgas < totcost) return -1;
        int gasAv = 0, start = 0;
        for(int i = 0; i < gas.size(); i++) {
            gasAv += (gas[i] - cost[i]);
            if(gasAv < 0) {
                gasAv = 0;
                start = i + 1;
            }
        }
        return start;
    }
};
