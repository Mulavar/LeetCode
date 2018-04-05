#include <cstdio>
#include <vector>
#include <map>

using namespace std;

class Solution
{
  public:
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
};

int main()
{
    vector<int> vec;
    Solution s;
    vec.push_back(3);
    vec.push_back(5);
    vec.push_back(4);

    vector<int> ans = s.twoSum(vec, 7);
    printf("%d %d\n", ans[0], ans[1]);
}