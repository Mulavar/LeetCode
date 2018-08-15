#include <cstdio>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

/*
    Maximal Square
*/

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        if(m==0) return 0;
        int n = matrix[0].size();
        int dp[m][n], ans = 0;
        memset(dp, 0, sizeof(dp));
        for(int i=0;i<m;i++){
            dp[i][0] = matrix[i][0] - '0';
            ans = max(ans, dp[i][0]);
        }
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i] - '0';
            ans = max(ans, dp[0][i]);
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='0') dp[i][j] = 0;
                else{
                    int st = dp[i][j] = min(dp[i-1][j], dp[i][j-1]);
                    if(matrix[i-st][j-st]=='1') dp[i][j] += 1;
                    ans = max(ans, dp[i][j]);
                }
            }
        }
        ans *= ans;
        return ans;
    }
};