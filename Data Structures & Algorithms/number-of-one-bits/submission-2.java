class Solution {
    public int hammingWeight(int n) {
        int c = 0, i = 0;
        for(; i < 31; i++) {
            if((n & (1 << i)) == (1 << i)) c++;
        }
        return c;
    }
}
