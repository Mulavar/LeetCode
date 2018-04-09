#include <cstdio>
#include <vector>
#include <stack>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution
{
  public:
    vector<int> inorderTraversal(TreeNode *root)
    {
        vector<int> ans;
        stack<TreeNode *> s;
        TreeNode *node = root;
        //s.push(root);
        while (!s.empty() || node != NULL)
        {
            while (node != NULL)
            {
                s.push(node);
                node = node->left;
            }
            node = s.top();
            s.pop();
            ans.push_back(node->val);
            node = node->right;
        }

        return ans;
    }
};