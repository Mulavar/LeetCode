#include <cstdio>
#include <vector>

using namespace std;

/*
    Jump Game II
*/

int jump(vector<int> &nums)
{
    int sz = nums.size();
    if (sz == 1)
        return 0;
    int pos = 0, sat = 0, m_dis = 0, step = 0, i = 0;
    while (true)
    {
        m_dis = 0;
        pos = nums[sat] + sat;
        if (pos >= sz - 1)
        {
            return step + 1;
        }
        for (; i <= pos; i++)
        {
            if (nums[i] + i > m_dis)
            {
                sat = i;
                m_dis = nums[i] + i;
            }
        }
        step++;
    }
}

int jump_concise(vector<int> nums)
{
    int sz = nums.size(), pos = 0, farthest = 0, step = 0;
    for (int i = 0; i < sz - 1; i++)
    {
        farthest = max(i + nums[i], farthest);

        if (i == pos)
        {
            pos = farthest;
            step++;
        }
    }
    return step;
}