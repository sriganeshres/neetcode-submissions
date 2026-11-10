class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if(freq1[i] == freq2[i]) matches++;
        }

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++) {
            if(matches == 26) return true;

            int idx = s2.charAt(r) - 'a';
            freq2[idx]++;
            if(freq1[idx] == freq2[idx]) {
                matches++;
            } else if (freq1[idx] + 1 == freq2[idx]) {
                matches--;
            }

            idx = s2.charAt(l) - 'a';
            freq2[idx]--;
            if(freq1[idx] == freq2[idx]) {
                matches++;
            } else if (freq1[idx] - 1 == freq2[idx]) {
                matches--;
            }

            l++;
        }
        return matches == 26;
    }
}
