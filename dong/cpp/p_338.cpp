#include <cstdio>
#include <vector>

using namespace std;

/*
    Counting Bits
*/

vector<int> countBits(int num)
{
    vector<int> ans(num + 1, 0);
    int bits = 0;
    for (int i = 0; i <= num; i++)
    {
        bits = 0;
        int k = i;
        while (k)
        {
            k = k & (k - 1);
            bits++;
        }
        ans[i] = bits;
    }

    return ans;
}

vector<int> countBits1(int num)
{
    vector<int> ans(num + 1, 0);
    for (int i = 0; i <= num; i++)
    {
        ans[i] = (i == 0) ? 0 : ans[i >> 1] + i & 1;
    }
    return ans;
}