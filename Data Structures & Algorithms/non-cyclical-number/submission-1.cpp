class Solution {
public:
    bool isHappy(int n) {
        int slow = n;
        int fast = sumofsquares(n);
        while(slow != fast) {
            fast = sumofsquares(fast);
            fast = sumofsquares(fast);
            slow = sumofsquares(slow);
        }

        return fast == 1;
    }

    int sumofsquares(int n) {
        int ans = 0;
        while(n > 0) {
            int d = n % 10;
            n /= 10;
            ans += (d*d);
        }

        return ans;
    }
};
