#include <cstdio>
#include <string>

using namespace std;

/*
    Is Subsequence
*/

bool isSubsequence(string s, string t) {
    int last = -1;
    for(char c: s){
        int pos = t.find(c, last+1);
        if(pos==-1) return false;
        last = pos;
    }
    return true;
}