class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 0, r = x;
        int res = 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if((long) mid* mid > x) {
                r = mid - 1;
            } else if((long) mid * mid < x) {
                l = mid + 1;
                res = mid;
            } else {
                return mid;
            }
        }
        return res;
    }
}