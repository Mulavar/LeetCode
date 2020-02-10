import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @ClassName P113PathSumII
 * @date 2020/2/10
 */
public class P113PathSumII {
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            ArrayList<List<Integer>> result = new ArrayList<>();

            if (root!=null) {
                walk(result, new ArrayList<Integer>(), root, sum);
            }
            return result;
        }

        private void walk(List<List<Integer>> result, List<Integer> path, TreeNode root, int target) {
            if (root.left == null && root.right == null) {
                if (root.val == target) {
                    List<Integer> singleRes = new ArrayList<>(path);
                    singleRes.add(root.val);
                    result.add(singleRes);
                }
                return;
            }

            path.add(root.val);
            if (root.left != null) {
                walk(result, path, root.left, target - root.val);
            }

            if (root.right != null) {
                walk(result, path, root.right, target - root.val);
            }
            path.remove(path.size() - 1);

        }
    }
}
