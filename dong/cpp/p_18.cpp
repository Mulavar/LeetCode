#include <cstdio>
#include <vector>

using namespace std;

/*
    4Sum
*/

vector<vector<int>> fourSum(vector<int> &nums, int target)
{
    vector<vector<int>> ans;
    sort(nums.begin(), nums.end());
    int n = nums.size();
    for (int i = 0; i < n - 3; i++)
    {
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        int j = i + 1;
        for (; j < n - 2; j++)
        {
            if (j > i + 1 && nums[j] == nums[j - 1])
                continue;
            int l = j + 1, r = n - 1, res = target - (nums[i] + nums[j]);
            while (l < r)
            {
                if (nums[l] + nums[r] == res)
                {
                    vector<int> tmp;
                    tmp.push_back(nums[i]);
                    tmp.push_back(nums[j]);
                    tmp.push_back(nums[l]);
                    tmp.push_back(nums[r]);
                    ans.push_back(tmp);
                    while (nums[l + 1] == nums[l] && l < r)
                        l++;
                    while (nums[r - 1] == nums[r] && l < r)
                        r--;
                    l += 1;
                    r -= 1;
                }
                else if (nums[l] + nums[r] < res)
                    l++;
                else
                    r--;
            }
        }
    }
    return ans;
}