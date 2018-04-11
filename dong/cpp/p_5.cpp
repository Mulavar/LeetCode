#include <cstdio>
#include <string>
#include <algorithm>
#include <iostream>

using namespace std;

class Solution
{
  public:
    string longestPalindrome(string s)
    {
        //遍历，以每次遍历到的点为中心向外拓展，比较reverse的结果是否相等
        string ans, str1, str2;
        int maxLen = 0, k = 0;//k用于记录每次遍历到某点，向外拓展的最少长度
        for (int i = 0; i < s.size(); i++)
        {
            //当最长对称子串长度为奇数
            for (int j = k; j <= min(i, (int)s.size() - i); j++)//如果j=0会超时
            {
                str1 = s.substr(i - j, 2 * j + 1);
                str2 = str1;
                reverse(str2.begin(), str2.end());
                if (str1 == str2)
                {
                    if (str1.size() > maxLen)
                    {
                        ans = str1;
                        k = j;
                        maxLen = str1.size();
                    }
                }
                else
                    break;
            }

            //当最长对称子串长度为偶数
            for (int j = k; j <= min(i, (int)s.size() - i - 1); j++)
            {
                str1 = s.substr(i - j, 2 * (j + 1));
                str2 = str1;
                reverse(str2.begin(), str2.end());
                if (str1 == str2)
                {
                    if (str1.size() > maxLen)
                    {
                        ans = str1;
                        k = j;
                        maxLen = str1.size();
                    }
                }
                else
                    break;
            }
        }
        return ans;
    }
};

int main()
{
    Solution s;
    string str1 = "babad";
    string str2 = "cbbd";
    string str3 = "tattarrattat";

    string ans1 = s.longestPalindrome(str1);
    string ans2 = s.longestPalindrome(str2);
    string ans3 = s.longestPalindrome(str3);

    cout << ans1 << endl;
    cout << ans2 << endl;
    cout << ans3 << endl;
}