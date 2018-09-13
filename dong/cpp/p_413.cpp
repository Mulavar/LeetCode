#include <cstdio>
#include <vector>

using namepsace std;

/*
    Arithmetic Slices
*/
int numberOfArithmeticSlices(vector<int>& A) {
    int ans = 0, cur = 0;
    
    for(int i=2;i<A.size();i++){
        if(A[i]-A[i-1]==A[i-1]-A[i-2]){
            cur += 1;
            ans += cur;
        }
        else
            cur = 0;
    }
    
    return ans;
}