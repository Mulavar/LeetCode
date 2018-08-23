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

int jump_concise(vector<int> nums){
    int sz = nums.size(), pos = nums[0] + 0;

    for(int i=1;i<sz - 1&&i<=pos;i++){
        pos = max(pos, nums[i] + i);
    }
    return pos >= sz - 1;
}