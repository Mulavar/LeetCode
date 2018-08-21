#include <cstdio>
#include <vector>

using namespace std;

/*
    3Sum
*/

vector<vector<int>> threeSum(vector<int> &nums)
{
    int sz = nums.size();
    vector<vector<int>> ans;
    if (sz < 3)
        return ans;
    sort(nums.begin(), nums.end());

    for (int i = 0; i < sz - 2; i++)
    {
        if (i > 0 && nums[i] == nums[i - 1])
            continue;
        int l = i + 1, r = sz - 1;
        while (l < r)
        {
            if (nums[l] + nums[r] == -nums[i])
            {
                vector<int> tmp;
                tmp.push_back(nums[i]);
                tmp.push_back(nums[l]);
                tmp.push_back(nums[r]);
                ans.push_back(tmp);
                while (l < r && nums[l + 1] == nums[l])
                    l++;
                while (r > l && nums[r - 1] == nums[r])
                    r--;
                l++;
                r--;
            }
            else if (nums[l] + nums[r] < -nums[i])
                l++;
            else
                r--;
        }
    }
    return ans;
}