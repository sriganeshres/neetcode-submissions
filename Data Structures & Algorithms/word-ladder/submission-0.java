class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> s = new HashSet<>();
        for(String w: wordList) s.add(w);
        int res = 0;
        while(!q.isEmpty()) {
            res++;
            int len = q.size();
            for(int i = 0; i < len; i++) {
                String word = q.poll();
                if(word.equals(endWord)) return res;
                for(int j = 0; j < word.length(); j++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(word.charAt(j) == c) continue;
                        String nw = word.substring(0, j) + c + word.substring(j + 1);
                        if(s.contains(nw)) {
                            q.add(nw);
                            s.remove(nw);
                        }
                    }
                }
            } 
        }

        return 0;
    }
}
