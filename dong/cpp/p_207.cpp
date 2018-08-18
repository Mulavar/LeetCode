#include <cstdio>
#include <vector>
#include <queue>

using namespace std;

/*
    Course Schedule
*/


bool canFinish(int numCourses, vector<pair<int, int>> &prerequisites)
{
    vector<int> node[numCourses];
    int in[numCourses], n = 0;
    queue<int> q;
    memset(in, 0, sizeof(in));
    for (vector<pair<int, int>>::iterator iter = prerequisites.begin(); iter != prerequisites.end(); iter++)
    {
        int u = iter->first;
        int v = iter->second;
        node[u].push_back(v);
        in[v]++;
    }
    for (int i = 0; i < numCourses; i++)
        if (in[i] == 0)
            q.push(i);

    while (!q.empty() && n++ < numCourses - 1)
    {
        int u = q.front();
        q.pop();
        for (int i = 0; i < node[u].size(); i++)
        {
            int v = node[u][i];
            if (--in[v] == 0)
                q.push(v);
        }
    }
    // for(int i=0;i<numCourses;i++)
    //     if(in[i])
    //         return false;
    if (n < numCourses - 1)
        return false;
    return true;
}