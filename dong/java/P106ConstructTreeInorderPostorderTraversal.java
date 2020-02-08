import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * @author Lam
 * @ClassName P106ConstructTreeInorderPostorderTraversal
 * @date 2020/2/8
 */
public class P106ConstructTreeInorderPostorderTraversal {
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return build(map, postorder, 0, inorder, 0, inorder.length);
        }

        private TreeNode build(Map<Integer, Integer> map, int[] postorder, int postSt, int[] inorder, int inSt, int len) {
            if (len == 0) {
                return null;
            }

            TreeNode root = new TreeNode(postorder[postSt + len - 1]);
            int mid = map.get(postorder[postSt + len - 1]);
            root.left = build(map, postorder, postSt, inorder, inSt, mid - inSt);
            root.right = build(map, postorder, postSt + mid - inSt, inorder, mid + 1, inSt + len - mid - 1);
            return root;
        }
    }
}
