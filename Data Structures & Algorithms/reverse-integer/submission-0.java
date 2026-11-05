class Solution {
    public int reverse(int x) {
        final int MIN = -2147483648; // -2^31
        final int MAX = 2147483647;
        int sign = x > 0 ? 1 : -1;
        if(x <= MIN || x > MAX) return 0;
        int absx = Math.abs(x);
        long t = 0;
        while(absx > 0) {
            t = t * 10 + absx % 10;
            absx /= 10;
        }
        t *= sign;
        if(t > Integer.MAX_VALUE || t < Integer.MIN_VALUE) return 0;
        return (int)t;
    }
}
