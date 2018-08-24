#include <cstdio>
#include <vector>
#include <map>

using namespace std;

/*
	Two Sum
*/

vector<int> twoSum(vector<int> &nums, int target)
{
    map<int, int> mp;
    int l = 0;
    vector<int> res;
    while (l < nums.size())
    {
        if (mp.find(target - nums[l]) != mp.end())
        {
            res.push_back(mp[target - nums[l]]);
            res.push_back(l);
            return res;
        }
        mp[nums[l]] = l;
        l++;
    }
    return res;
}
