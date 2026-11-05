class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int maxK = -1;
        for(int k: piles) maxK = max(maxK, k);
        int l = 1, r = maxK, res = maxK;
        while(l <= r) {
            int speed = l + (r-l) / 2;
            long time = 0;
            for(int k: piles) time += ceil(double(k) / speed);
            if(time <= h) {
                res = speed;
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }
        return res;
    }
};
