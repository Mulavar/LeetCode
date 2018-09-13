#include <cstdio>
#include <vector>

using namespace std;

/*
    Rotate Image
*/

void rotate(vector<vector<int>>& matrix) {
    int sz = matrix.size();
    for(int i=0;i<sz;i++)
        for(int j=sz-1;j>=0;j--)
            matrix[i].push_back(matrix[j][i]);
        
    for(int i=0;i<sz;i++)
        for(int j=0;j<sz;j++)
            matrix[i].erase(matrix[i].begin());
}