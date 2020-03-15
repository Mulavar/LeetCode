import bean.TreeNode;

/**
 * @author Lam
 * @ClassName P1123LowestCommonAncestorDeepestLeaves
 * @date 2020/2/22
 */
public class P1123LowestCommonAncestorDeepestLeaves {
    class Solution {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            if(root==null) {
                return null;
            }
            int leftH = depth(root.left);
            int rightH = depth(root.right);
            if(leftH==rightH) {
                return root;
            }else if(leftH<rightH) {
                return lcaDeepestLeaves(root.right);
            } else {
                return lcaDeepestLeaves(root.left);
            }
        }

        private int depth(TreeNode root) {
            if(root==null){
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
}
