#include <cstdio>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;
/*
    Maximum Product Subarray
*/

class Solution
{
  public:
    int maxProduct(vector<int> &nums)
    {
        int sz = nums.size();
        int dmin[sz], dmax[sz];
        memset(dmin, 0, sizeof(dmin));
        memset(dmax, 0, sizeof(dmax));
        dmin[0] = dmax[0] = nums[0];
        for (int i = 1; i < sz; i++)
        {
            dmax[i] = max(nums[i], max(dmax[i - 1] * nums[i], dmin[i - 1] * nums[i]));
            dmin[i] = min(nums[i], min(dmax[i - 1] * nums[i], dmin[i - 1] * nums[i]));
        }
        int ans = INT_MIN;
        for (int i = 0; i < sz; i++)
            ans = max(ans, dmax[i]);
        return ans;
    }
};