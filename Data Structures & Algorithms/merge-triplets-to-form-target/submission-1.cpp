class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        set<int> good;
        for(auto triplet : triplets) {
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            for(int i = 0; i < 3; i++) {
                if(triplet[i] == target[i]) {
                    good.insert(i);
                }
            }
        }

        return good.size() == 3;
    }
};
