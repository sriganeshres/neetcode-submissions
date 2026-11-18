class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        set<string> words(wordList.begin(), wordList.end());
        if (words.find(endWord) == words.end() || endWord == beginWord) return 0;
        queue<string> q;
        q.push(beginWord);
        int res = 0;
        while(!q.empty()) {
            res++;
            int n = q.size();
            for(int i = 0; i < n; i++) {
                string node = q.front();
                q.pop();
                if(node == endWord) return res;
                for(int j = 0; j < node.length(); j++) {
                    char og = node[j];
                    for(char k = 'a'; k <= 'z'; k++) {
                        if (k == og) continue;
                        node[j] = k;
                        if(words.find(node) != words.end()) {
                            q.push(node);
                            words.erase(node);
                        }
                    }
                    node[j] = og;
                }
            }
        }

        return 0;
    }
};
