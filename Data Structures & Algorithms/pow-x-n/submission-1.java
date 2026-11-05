class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n < 0) {
            int abs = n * -1;
            if(abs % 2 == 0)
                return 1 / (myPow(x, abs/2) * myPow(x, abs/2));
            return 1 / (myPow(x, abs/2) * myPow(x, abs/2) * x);
        }

        if(n % 2 == 0)
            return myPow(x, n/2) * myPow(x, n/2);
        return myPow(x, n/2) * myPow(x, n/2) * x;
    }
}
