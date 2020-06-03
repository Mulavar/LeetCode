#include <iostream>
#include <string>
#include <stack>

using namespace std;

int longestValidParentheses(string s)
{
    stack<int> pts;
    int result = 0;
    int preLen = 0;
    int curLen = 0;
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] == '(')
        {
            if (pts.empty())
            {
                preLen = curLen;
                curLen = 0;
            }

            pts.push(i);
        }
        else
        {
            if (!pts.empty())
            {
                pts.pop();
                if (!pts.empty())
                {
                    int left = pts.top();
                    curLen = i - left;
                }
                else
                {
                    curLen += 2;
                    curLen += preLen;
                }
                result = max(result, curLen);
            }
            else
            {
                curLen = 0;
                preLen = 0;
            }
        }
    }
    return result;
}

int main()
{
    cout << longestValidParentheses(")()())");
}
