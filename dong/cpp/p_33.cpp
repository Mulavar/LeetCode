#include <cstdio>
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.empty()) return -1;
        int l = 0, r = nums.size() - 1;
        while(l<r){
            int mid = (l + r) / 2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>nums[r]){
                if(nums[r]>target) l = mid + 1;
                else if(nums[r]<target){
                    if(nums[mid]<target) l = mid + 1;
                    else r = mid - 1;
                }
                else return r;
            }
            else{
                if(nums[mid]>target) r = mid - 1;
                else{
                    if(nums[r]>target) l = mid + 1;
                    else if(nums[r]<target) r = mid - 1;
                    else return r;
                }
            }
        }
        if(nums[l]==target) return l;
        else return -1;
    }
};

int main(){
    Solution s;
    vector<int> nums;
    for(int i=0;i<8;i++){
        nums.push_back((i+4)%8);
    }

    printf("%d\n", s.search(nums, 5));
}