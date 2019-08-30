#include <cstdio>
#include <set>
#include <string>
#include <algorithm>
#include <map>

using namespace std;

//注释的部分用于调试
class Solution
{
  public:
    int lengthOfLongestSubstring(string s)
    {
        map<char, int> mp;
        int l = 0, r = l, ans = 0;
        while (r < s.size())
        {
            if (mp.find(s[r]) != mp.end() && mp[s[r]] >= l)
            {
                // printf("%c: %d\n", s[r], mp[s[r]]);
                ans = max(ans, r - l);
                l = mp[s[r]] + 1;
                // printf("ans: %d\nl: %d\n", ans, l);
                mp.erase(mp.find(s[r]));
                mp[s[r]] = r;
            }
            else
            {
                mp[s[r]] = r;
            }
            r++;
        }
        ans = max(ans, r - l);
        return ans;
    }
};

int main()
{
    Solution s;
    string s1 = "abcabcbb";
    string s2 = "bbbbb";
    string s3 = "pwwkew";
    string s4 = "qwnfenpglqdq";
    int ans1 = s.lengthOfLongestSubstring(s1);
    int ans2 = s.lengthOfLongestSubstring(s2);
    int ans3 = s.lengthOfLongestSubstring(s3);
    int ans4 = s.lengthOfLongestSubstring(s4);
    printf("s1: %d\ns2: %d\ns3: %d\ns4: %d\n", ans1, ans2, ans3, ans4);
}
