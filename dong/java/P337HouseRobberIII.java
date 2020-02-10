import java.util.HashMap;
import java.util.Map;

/**
 * @author Lam
 * @ClassName P337HouseRobberIII
 * @date 2020/2/10
 */
public class P337HouseRobberIII {
    class Solution {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        // 这种解法对root.left.left会重复计算，造成大量浪费
        public int rob(TreeNode root) {
            return solve(root, true);
        }

        private int solve(TreeNode root, boolean flag) {
            if (root == null) {
                return 0;
            }

            if (!flag) {
                return solve(root.left, true) + solve(root.right, true);
            } else {
                return Math.max(root.val + solve(root.left, false) + solve(root.right, false),
                        solve(root.left, true) + solve(root.right, true));
            }
        }
    }

    class Solution1 {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        // 使用map去重优化，2ms，beat 56%
        public int rob(TreeNode root) {
            HashMap<TreeNode, Integer> map = new HashMap<>();
            return solve(root, true, map);
        }

        private int solve(TreeNode root, boolean flag, Map<TreeNode, Integer> map) {
            if (root == null) {
                return 0;
            }


            if (!flag) {
                return solve(root.left, true, map) + solve(root.right, true, map);
            } else {
                if (map.containsKey(root)) {
                    return map.get(root);
                }
                int sum = Math.max(root.val + solve(root.left, false, map) + solve(root.right, false, map),
                        solve(root.left, true, map) + solve(root.right, true, map));
                map.put(root, sum);
                return sum;
            }
        }
    }

    class Solution2 {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        // 采用dp思想，使用后序遍历，从底往上可以看做一个个dp数组，
        // 然后继续采用dp[i] = max(dp[i-1], dp[i-2]+num[i])的做法
        public int rob(TreeNode root) {
            return solve(root);
        }

        private int solve(TreeNode root) {
            if (root == null) {
                return 0;
            }

            //dp[i-1]
            int sonLeft = solve(root.left);
            int sonRight = solve(root.right);

            //dp[i-2]
            int grandSonLeft = calcSon(root.left);
            int grandSonRight = calcSon(root.right);

            //dp[i] = max(dp[i-1], dp[i-2]+num[i])
            root.val = Integer.max(sonLeft + sonRight, grandSonLeft + grandSonRight + root.val);
            return root.val;
        }

        private int calcSon(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return (root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val);
        }
    }
}
