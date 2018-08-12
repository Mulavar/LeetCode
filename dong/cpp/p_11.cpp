#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

/*
    Container With Most Water
*/
class Solution {
public:
    int maxArea(vector<int>& height) {
        int sz = height.size();
        
        int l_idx[sz], r_idx[sz], water[sz], dis[sz], k = 0;
        int tmax = 0, idx = 0;
        for(int i=0;i<sz;i++){
            if(height[i]>tmax){
                tmax = height[i];
                idx = i;
            }
            l_idx[i] = idx;
        }
        tmax = 0;
        
        for(int i=sz-1;i>=0;i--){
            if(height[i]>tmax){
                tmax = height[i];
                idx = i;
            }
            r_idx[i] = i;
        }

        for(int i=0;i<sz;i++){
            if(l_idx[i]==i||r_idx[i]==i){
                water[k] = height[i];
                dis[k++] = i;
            }
        }
        
        int ans = 0;
        for(int i=1;i<k;i++){
            for(int j=0;j<i;j++){
                ans = max(ans, min(water[i], water[j]) * (dis[i] - dis[j]));
            }
        }
        return ans;
    }
};