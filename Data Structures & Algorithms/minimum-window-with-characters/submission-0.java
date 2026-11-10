class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int[] windowFreq = new int[128];
        int required = 0;
        for (int count : tFreq) {
            if (count > 0) required++;
        }

        int l = 0, formed = 0;
        int minLen = Integer.MAX_VALUE;
        int finalL = -1, finalR = -1;
        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            windowFreq[rChar]++;

            if (tFreq[rChar] > 0 && windowFreq[rChar] == tFreq[rChar]) {
                formed++;
            }

            while (formed == required) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    finalL = l;
                    finalR = r;
                }

                char lChar = s.charAt(l);
                windowFreq[lChar]--;

                if (tFreq[lChar] > 0 && windowFreq[lChar] < tFreq[lChar]) {
                    formed--;
                }
                l++;
            }
        }

        if (finalL == -1) return "";
        return s.substring(finalL, finalR + 1);
    }
}
