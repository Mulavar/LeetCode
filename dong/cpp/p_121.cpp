#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

/*
    Best Time to Buy and Sell Stock
*/
class Solution
{
  public:
    int maxProfit(vector<int> &prices)
    {
        int sz = prices.size();
        if (sz == 0)
            return 0;
        int r_max[sz], tmp = 0, ans = 0;
        memset(r_max, 0, sizeof(r_max));
        for (int i = sz - 1; i >= 0; i--)
        {
            tmp = max(tmp, prices[i]);
            r_max[i] = tmp;
        }
        for (int i = 0; i < sz; i++)
        {
            ans = max(ans, r_max[i] - prices[i]);
        }
        return ans;
    }
};