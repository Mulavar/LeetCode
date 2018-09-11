#include <cstdio>
#include <vector>

using namespace std;

/*
    Search Insert Position
*/

int searchInsert(vector<int> &nums, int target)
{
    int sz = nums.size(), idx = 0;
    while (idx < sz)
    {
        if (nums[idx] < target)
            idx++;
        else
            break;
    }
    return idx;
}