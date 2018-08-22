#include <cstdio>
#include <vector>

using namespace std;

/*
    Find First and Last Position of Element in Sorted Array
*/

vector<int> searchRange(vector<int> &nums, int target)
{
    vector<int> ans;

    int l = 0, r = (int)nums.size() - 1;
    while (l <= r)
    {
        int mid = (l + r) / 2;
        if (nums[mid] == target)
        {
            int tl = mid, tr = mid;
            while (tl >= l && nums[tl] == target)
                tl--;
            while (tr <= r && nums[tr] == target)
                tr++;
            ans.push_back(tl + 1);
            ans.push_back(tr - 1);
            return ans;
        }
        else if (nums[mid] < target)
            l = mid + 1;
        else
            r = mid - 1;
    }

    if (!ans.size())
    {
        ans.push_back(-1);
        ans.push_back(-1);
        return ans;
    }
}