class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;
        for(int n: weights) {
            min = Math.max(min, n);
            max += n;
        }
        int res = max;
        while(min <= max) {
            int mid = (min + max) / 2;
            if(f(weights, days, mid)) {
                res = Math.min(res, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        } 
        return res;
    }

    public boolean f(int[] weights, int days, int w) {
        int day = 1, rem = w;
        for(int n: weights) {
            if(rem - n < 0) {
                day++;
                if(day > days) return false;
                rem = w;
            }
            rem -= n;
        }
        return true;
    }
}