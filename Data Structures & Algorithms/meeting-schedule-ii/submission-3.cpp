/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
public:
    int minMeetingRooms(vector<Interval>& intervals) {
        map<int, int> mp;
        for(auto inter : intervals) {
            mp[inter.start]++;
            mp[inter.end]--;
        }
        int active = 0, maxActive = 0;
        for (auto e: mp) {
            active += e.second;
            maxActive = max(active, maxActive);
        }

        return maxActive;
    }
};
