class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if (s1.length() > s2.length()) return false;
        vector<int> freq1(26, 0), freq2(26, 0);
        int matches = 0;
        for(int i = 0; i < s1.length(); i++) {
            freq1[s1[i] - 'a']++;
            freq2[s2[i] - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if (freq1[i] == freq2[i]) matches++;
        }
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;

            int idx = s2[r] - 'a';
            freq2[idx]++;
            if (freq1[idx] == freq2[idx]) matches++;
            if (freq1[idx] + 1 == freq2[idx]) matches--;

            idx = s2[l] - 'a';
            freq2[idx]--;
            if (freq1[idx] == freq2[idx]) matches++;
            if (freq1[idx] - 1 == freq2[idx]) matches--;

            l++;
        }

        return matches == 26;
    }
};
