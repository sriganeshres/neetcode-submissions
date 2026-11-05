class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(n != 1 && !hs.contains(n)) {
            hs.add(n);
            // System.out.println(summ(n));
            n = summ(n);
        }
        return n == 1;
    }

    public int summ(int n) {
        int sum = 0;
        while(n > 0) {
            int x = n % 10;
            sum += x*x;
            n /= 10;
        }
        return sum;
    }
}
