class Solution {
public:
    int hammingWeight(uint32_t n) {
        int c = 0, i = 0;
        for(; i < 31; i++) {
            c += ((n & (1 << i)) == (1 << i));
        }
        return c;
    }
};
