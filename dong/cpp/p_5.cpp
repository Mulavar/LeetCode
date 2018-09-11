#include <cstdio>
#include <string>
#include <algorithm>
#include <iostream>

using namespace std;

/*
    Longest Palindromic Substring
*/

string longestPalindrome(string s)
{
    //遍历，以每次遍历到的点为中心向外拓展，比较reverse的结果是否相等
    string ans, str1, str2;
    int maxLen = 0, k = 0; //k用于记录每次遍历到某点，向外拓展的最少长度
    for (int i = 0; i < s.size(); i++)
    {
        //当最长对称子串长度为奇数
        for (int j = k; j <= min(i, (int)s.size() - i); j++) //如果j=0会超时
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

string longestPalindrome1(string s)
{
    int len = s.length(), ans = 0, st = 0;
    if (len == 0)
        return "";
    int dp[len][len];
    memset(dp, 0, sizeof(dp));
    for (int i = 0; i < len; i++)
        ans = dp[i][i] = 1;
    for (int i = 0; i < len - 1; i++)
        if (s[i] == s[i + 1])
        {
            dp[i][i + 1] = 2;
            st = (dp[i][i + 1] > ans) ? i : st;
            ans = max(ans, dp[i][i + 1]);
        }

    for (int i = 2; i < len; i++)
    {
        for (int j = 0; j < len - i; j++)
        {
            if (s[j + i] == s[j] && dp[j + 1][i + j - 1])
            {
                dp[j][i + j] = dp[j + 1][i + j - 1] + 2;
                st = (dp[j][i + j] > ans) ? j : st;
                ans = max(ans, dp[j][i + j]);
            }
        }
    }

    return s.substr(st, ans);
}
