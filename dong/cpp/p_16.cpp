#include <cstdio>
#include <vector>

using namespace std;

/*
    3Sum Closest
*/

int threeSumClosest(vector<int> &nums, int target)
{
    sort(nums.begin(), nums.end());
    int sz = nums.size(), max_sub = INT_MAX, flag = 0;
    for (int i = 0; i < sz - 2; i++)
    {
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        int l = i + 1, r = sz - 1;
        while (l < r)
        {
            int tmp = nums[l] + nums[r] + nums[i];
            if (tmp == target)
                return target;
            else
            {
                max_sub = min(max_sub, abs(target - tmp));
                flag = max_sub == abs(target - tmp) ? target - tmp : flag;
                if (target - tmp > 0)
                    l++;
                else
                    r--;
            }
        }
    }
    if (flag > 0)
        return target - max_sub;
    else
        return target + max_sub;
}