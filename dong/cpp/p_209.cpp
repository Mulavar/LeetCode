#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;
/*
    Minimum Size Subarray Sum
*/
class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int sz = nums.size(); 
        int ans = 100000, l = 0, r = 0, sum = 0;
        
        while(r<sz&&l<=r){
            if(sum<s){
                sum += nums[r++];
            }
            else{
                ans = min(ans, r - l);
                sum -= nums[l++];  
            }
        }
        
        while(sum>=s){
            ans = min(ans, r - l);
            sum -= nums[l++]; 
        }
        
        if(ans==100000) ans = 0;
        return ans;
    }
};