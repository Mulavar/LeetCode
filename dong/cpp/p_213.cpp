#include <cstdio>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;
/*
    House Robber II
*/

class Solution {
public:
	int rob(vector<int>& nums) {
		int sz = nums.size();
		if (sz == 0) return 0;
		else if (sz == 1) return nums[0];
		else if (sz == 2) return max(nums[0], nums[1]);
		int d1[sz], d2[sz];
		memset(d1, 0, sizeof(d1));
		memset(d2, 0, sizeof(d2));
		d1[0] = nums[0];
		d1[1] = max(nums[0], nums[1]);
		d2[1] = nums[1];
		d2[2] = max(nums[1], nums[2]);
		for (int i = 2; i<sz - 1; i++) {
			d1[i] = max(d1[i - 1], d1[i - 2] + nums[i]);
		}
		for (int i = 3; i<sz; i++) {
			d2[i] = max(d2[i - 1], d2[i - 2] + nums[i]);
		}
		return max(d1[sz - 2], d2[sz - 1]);
	}
};

int main() {
	int n;
	vector<int> nums;
	nums.push_back(4);
	nums.push_back(1);
	nums.push_back(2);
	nums.push_back(1);
	nums.push_back(3);
	Solution s = Solution();
	printf("%d\n", s.rob(nums));

}
