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
    bool canAttendMeetings(vector<Interval>& intervals) {
        map<int, int> mp;
        for(auto inter : intervals) {
            mp[inter.start]++;
            mp[inter.end]--;
        }
        int active = 0;
        for (auto e: mp) {
            active += e.second;
            if (active > 1) return false;
        }

        return true;
    }
};
