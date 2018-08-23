#include <cstdio>
#include <vector>

using namespace std;

/*
    Trapping Rain Water
*/

int trap(vector<int> &height)
{
    int sz = height.size();
    if (sz < 2)
        return 0;
    int l[sz], r[sz], l_max = height[0], r_max = height[sz - 1], l_idx = 0, r_idx = sz - 1, ans = 0;
    l[0] = 0;
    r[sz - 1] = sz - 1;
    for (int i = 1; i < sz; i++)
    {
        if (height[i] > l_max)
        {
            l_max = height[i];
            l_idx = i;
        }
        l[i] = l_idx;
    }

    for (int i = sz - 2; i >= 0; i--)
    {
        if (height[i] > r_max)
        {
            r_max = height[i];
            r_idx = i;
        }
        r[i] = r_idx;
    }

    for (int i = 0; i < sz; i++)
    {
        if (i == l[i] || i == r[i])
            continue;
        ans += (min(height[l[i]], height[r[i]]) - height[i]);
    }

    return ans;
}