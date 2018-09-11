#include <cstdio>
#include <vector>
#include <string>

using namespace std;

/*
    Implement strStr()
*/

static void getNext(int next[], string needle)
{
    next[0] = -1;
    int i = -1, j = 0;
    while (j < needle.length() - 1)
    {
        if (i == -1 || needle[i] == needle[j])
        {
            i++;
            j++;
            next[j] = i;
        }
        else
        {
            i = next[i];
        }
    }
}

int strStr(string haystack, string needle)
{
    if (!needle.length())
        return 0;
    int i = 0, j = 0, st = 0, len1 = haystack.length(), len2 = needle.length();
    int next[len2];
    getNext(next, needle);

    while (i < len1 && j < len2)
    {

        if (j == -1 || haystack[i] == needle[j])
        {
            i++;
            j++;
        }
        else
        {
            j = next[j];
        }
    }

    if (j == len2)
        return i - len2;
    return -1;
}