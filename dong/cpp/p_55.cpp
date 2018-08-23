#include <cstdio>
#include <vector>

using namespace std;

/*
    Jump Game
*/

bool canJump(vector<int> &nums)
{
    int sz = nums.size();
    if (!sz)
        return true;
    bool dp[sz];
    memset(dp, false, sizeof(dp));
    dp[0] = true;
    for (int i = 1; i < sz; i++)
    {
        for (int j = 0; j < i; j++)
        {
            if (!dp[j])
                continue;
            if (j + nums[j] >= i)
            {
                dp[i] = true;
                break;
            }
        }
    }
    return dp[sz - 1];
}