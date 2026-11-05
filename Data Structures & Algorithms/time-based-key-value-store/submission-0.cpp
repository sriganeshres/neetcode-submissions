class TimeMap {
public:
    map<string, vector<pair<int, string>>> mp;
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        mp[key].push_back({timestamp, value});
    }
    
    string get(string key, int timestamp) {
        vector<pair<int, string>> vals = mp[key];
        if(vals.empty()) return "";
        int l = 0, r = vals.size() - 1;
        string result = "";
        while(l <= r) {
            int mid =(l + r) / 2;
            if(vals[mid].first <= timestamp) {
                result = vals[mid].second;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
};
