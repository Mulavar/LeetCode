#include <cstdio>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;
/*
    House Robber
*/

class Solution {
public:
    int rob(vector<int>& nums) {
        int sz = nums.size();
        if(sz==0) return 0;
        else if(sz==1) return nums[0];
        int dp[sz];
        memset(dp, 0, sizeof(dp));
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for(int i=2;i<sz;i++){
            dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[sz-1];
    }
};