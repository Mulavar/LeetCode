#include <cstdio>
#include <vector>

using namespace std;

/*
    Longest Increasing Subsequence
*/

int lengthOfLIS(vector<int> &nums)
{
    int sz = nums.size();
    if (sz == 0)
        return 0;
    int dp[sz], ms = 1;
    for (int i = 0; i < sz; i++)
    {
        dp[i] = 1;
        for (int j = 0; j < i; j++)
        {
            if (nums[i] > nums[j])
            {
                dp[i] = max(dp[i], dp[j] + 1);
                ms = max(ms, dp[i]);
            }
        }
    }
    return ms;
}