class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        carry = digits[digits.length - 1] / 10;
        digits[digits.length - 1] %= 10;
        for(int i = digits.length - 2; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if(carry != 0){
            int[] newD = new int[digits.length + 1];
            newD[0] = carry;
            for(int i = 0; i < digits.length; i++) {
                newD[i + 1] = digits[i];
            }
            return newD;
        }

        return digits;
    }
}
