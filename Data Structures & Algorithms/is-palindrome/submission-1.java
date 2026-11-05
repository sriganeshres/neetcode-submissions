class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        // Keep only letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        // Check palindrome on the filtered string
        String clean = sb.toString();
        int i = 0, j = clean.length() - 1;
        while (i < j) {
            if (clean.charAt(i) != clean.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
