import bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * @author Lam
 * @ClassName P105ConstructTreePreorderInorderTraversal
 * @date 2020/2/8
 */
public class P105ConstructTreePreorderInorderTraversal {
    class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return build(map, preorder, 0, inorder, 0, preorder.length);
        }

        private TreeNode build(Map<Integer, Integer> map, int[] preorder, int preSt, int[] inorder, int inSt, int len) {
            if (len == 0) {
                return null;
            }
            int mid = map.get(preorder[preSt]);
            TreeNode root = new TreeNode(preorder[preSt]);
            root.left = build(map, preorder, preSt + 1, inorder, inSt, mid - inSt);
            root.right = build(map, preorder, preSt + mid - inSt + 1, inorder, mid + 1, inSt + len - mid - 1);
            return root;
        }
    }
}
