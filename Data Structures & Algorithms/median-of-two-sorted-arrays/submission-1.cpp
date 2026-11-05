class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        double median1, median2;
        int n = nums1.size(), m = nums2.size();
        vector<int> a = nums1, b = nums2;
        if(m < n) {
            swap(a, b);
        }
        n = a.size();
        m = b.size();
        int t = n + m, h = (t+1) / 2;
        int l = 0, r = n;
        while(l <= r) {
            int i = (l+r) / 2;
            int j = h - i;
            int Aleft = i > 0 ? a[i - 1] : INT_MIN;
            int Aright = i < n ? a[i] : INT_MAX;
            int Bleft = j > 0 ? b[j - 1] : INT_MIN;
            int Bright = j < m ? b[j] : INT_MAX;
            if(Aleft <= Bright && Aright >= Bleft){
                if (t % 2 != 0) {
                    return max(Aleft, Bleft);
                }
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright){
                r = i - 1;
            } else l = i + 1;
        }
        return -1;
    }
};
