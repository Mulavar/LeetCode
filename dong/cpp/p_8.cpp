#include <cstdio>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;
/*
    String to Integer (atoi)
*/


class Solution {
public:
    int myAtoi(string str) {
        int len = str.length(), start = 0, constant = 1;
        long ans = 0;
        for(int i=0;i<len;i++){
            if(str[i]==' ') continue;
            if(str[i]>'9'||str[i]<'0'&&str[i]!='+'&&str[i]!='-') return 0;
            else{
                start = i;
                break;
            }
        }
        // int start = str.find_first_not_of(' ');
        if(str[start]=='+')
            start++;
        else if(str[start]=='-'){
            constant=-1;
            start++;
        }
        
        while(start<len&&str[start]<='9'&&str[start]>='0'){
            ans = ans * 10 + str[start] - '0';
            start++;
            if(constant*ans>INT_MAX) return INT_MAX;
            else if(constant*ans<INT_MIN) return INT_MIN;
        }
        
        
        return ans*constant;
        
    }
};