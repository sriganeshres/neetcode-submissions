class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> pre(n);
        vector<int> suff(n);
        pre[0] = height[0];
        for(int i=1;i<n;i++) pre[i] = max(pre[i-1],height[i]);
        suff[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--) suff[i] = max(suff[i+1],height[i]);
        int ans = 0;
        for(int i=0;i<n;i++){
            int maxi = min(pre[i],suff[i]);
            ans+=(maxi-height[i]);
        }
        return ans;
    }
};
