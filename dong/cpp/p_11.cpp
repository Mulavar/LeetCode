#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

/*
    Container With Most Water
*/
class Solution
{
  public:
    int maxArea(vector<int> &height)
    {
        // 解法1：当height单调递增（递减）时，复杂度为O(n^2)
        // O(n)可看解法2
        int sz = height.size();

        int l_idx[sz], r_idx[sz], water[sz], dis[sz], k = 0;
        int tmax = 0, idx = 0;
        for (int i = 0; i < sz; i++)
        {
            if (height[i] > tmax)
            {
                tmax = height[i];
                idx = i;
            }
            l_idx[i] = idx;
        }
        tmax = 0;

        for (int i = sz - 1; i >= 0; i--)
        {
            if (height[i] > tmax)
            {
                tmax = height[i];
                idx = i;
            }
            r_idx[i] = i;
        }

        for (int i = 0; i < sz; i++)
        {
            if (l_idx[i] == i || r_idx[i] == i)
            {
                water[k] = height[i];
                dis[k++] = i;
            }
        }

        int ans = 0;
        for (int i = 1; i < k; i++)
        {
            for (int j = 0; j < i; j++)
            {
                ans = max(ans, min(water[i], water[j]) * (dis[i] - dis[j]));
            }
        }
        return ans;
    }

    int maxArea1(vector<int> &height)
    {
        // two pointers
        int l = 0, r = height.size() - 1;
        int ans = 0;
        while (l < r)
        {
            int h = min(height[l], height[r]);
            ans = max(ans, h * (r - l));
            while (l < r && height[l] <= h)
                l++;
            while (r > l && height[r] <= h)
                r--;
        }
        return ans;
    }
};