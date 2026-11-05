class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hp = new HashMap<>();
        for(String s: strs) {
            int freq[] = new int[26];
            for(char c: s.toCharArray()) {
                freq[c - 'a']++;
            }
            String freqS = Arrays.toString(freq);
            List<String> ls = new ArrayList<>();
            if(hp.containsKey(freqS)) {
                ls = hp.get(freqS);
            }
            ls.add(s);
            hp.put(freqS, ls);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> s: hp.values()) {
            ans.add(s);
        }
        return ans;
    }
}
