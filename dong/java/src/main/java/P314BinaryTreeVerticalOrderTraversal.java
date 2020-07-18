import bean.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个二叉树，返回其结点 垂直方向（从上到下，逐列）遍历的值。
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 *
 * @author Lam
 * @date 2020/7/18
 */
public class P314BinaryTreeVerticalOrderTraversal {
    Map<Integer, List<Node>> map = new TreeMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        inorder(root, 0, 0);

        // map中每一列按level排序
        map.values().stream().forEach(nodes -> {
            Collections.sort(nodes, Comparator.comparingInt(n -> n.level));
        });

        // 结构转换
        return map.values().stream().
                map(nodes -> nodes.stream().map(n -> n.val).collect(Collectors.toList())).
                collect(Collectors.toList());
    }

    /**
     * 中序遍历，将同一列的结点都先放到一个list中，再根据level排序
     *
     * @param level    纵坐标，记录从上到下
     * @param position 横坐标，记录从左到右
     */
    private void inorder(TreeNode root, int level, int position) {
        if (root == null) {
            return;
        }

        inorder(root.left, level + 1, position - 1);

        List<Node> values = map.getOrDefault(position, new ArrayList<>());
        values.add(new Node(level, root.val));
        map.put(position, values);

        inorder(root.right, level + 1, position + 1);
    }

    class Node {
        int level;
        int val;

        public Node(int level, int val) {
            this.level = level;
            this.val = val;
        }
    }
}
