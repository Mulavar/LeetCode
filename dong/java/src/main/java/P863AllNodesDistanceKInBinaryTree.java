import bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 * @author Lam
 * @ClassName P863AllNodesDistanceKInBinaryTree
 * @date 2020/5/18
 */
public class P863AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        preOrder(root, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int last = 1;
        int cur = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            last--;
            if (K == 0) {
                res.add(node.val);
            }

            if (K != 0 && node.left != null && !visited.contains(node.left)) {
                queue.offer(node.left);
                visited.add(node.left);
                cur++;
            }

            if (K != 0 && node.right != null && !visited.contains(node.right)) {
                queue.offer(node.right);
                visited.add(node.right);
                cur++;
            }

            TreeNode p = parent.get(node);
            if (K != 0 && parent.containsKey(node) && !visited.contains(p)) {
                queue.offer(p);
                visited.add(p);
                cur++;
            }

            if (last == 0) {
                last = cur;
                cur = 0;
                K--;
            }
        }
        return res;
    }

    private void preOrder(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root.left != null) {
            map.put(root.left, root);
            preOrder(root.left, map);
        }

        if (root.right != null) {
            map.put(root.right, root);
            preOrder(root.right, map);
        }
    }

    public List<Integer> distanceK1(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        dfs(root, target, K, res);
        return res;
    }

    private int dfs(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null) {
            return -1;
        } else if (root == target) {
            preOrder1(root, 0, K, res);
            return 1;
        }

        int l = dfs(root.left, target, K, res);
        int r = dfs(root.right, target, K, res);
        if (l != -1) {
            System.out.println("cur:" + root.val + ", l:" + l);
            if (l == K) {
                res.add(root.val);
            } else if (l < K) {
                preOrder1(root.right, 1, K - l, res);
            }
            return l + 1;
        }
        if (r != -1) {
            System.out.println("cur:" + root.val + ", r:" + r);
            if (r == K) {
                res.add(root.val);
            } else if (r < K) {
                preOrder1(root.left, 1, K - r, res);
            }
            return r + 1;
        }
        return -1;
    }

    private void preOrder1(TreeNode root, int h, int K, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (h == K) {
            res.add(root.val);
            return;
        }
        preOrder1(root.left, h + 1, K, res);
        preOrder1(root.right, h + 1, K, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);

        System.out.println(new P863AllNodesDistanceKInBinaryTree().distanceK1(root, root.right.left, 3));
    }
}
