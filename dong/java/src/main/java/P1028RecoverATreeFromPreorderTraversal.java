import bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。
 * （如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 * @author Lam
 * @ClassName P1028RecoverATreeFromPreorderTraversal
 * @date 2020/9/15
 */
public class P1028RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String S) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int start = 0;
        int end = start;

        // 利用栈和递归的思想，找出每个节点的存放位置
        while (end < S.length()) {
            // 解析level
            int level = 0;
            while (S.charAt(end) == '-') {
                level++;
                end++;
            }

            // 解析数字
            start = end;
            while (end < S.length() && isNumber(S.charAt(end))) {
                end++;
            }
            int value = Integer.parseInt(S.substring(start, end));

            TreeNode node = new TreeNode(value);
            // 左子树
            if (stack.size()==level) {
                if (!stack.isEmpty()) {
                    stack.peek().left = node;
                }
            }
            // 右子树
            else {
                while (level!=stack.size()) {
                    stack.poll();
                }
                stack.peek().right = node;
            }

            stack.push(node);
        }

        while (stack.size()>1) {
            stack.poll();
        }

        return stack.poll();
    }

    public TreeNode recoverFromPreorder1(String S) {
        int symbol = 0;
        int start = 0;
        int end = start;

        List<Node> list = new ArrayList<>();
        Node[] preorder;
        Node[] inorder;

        while (end < S.length()) {
            // 每找到'-'和数字的组合就做预处理
            if (isNumber(S.charAt(end))) {
                start = end;
                while (end < S.length() && isNumber(S.charAt(end))) {
                    end++;
                }
                list.add(new Node(start - symbol, Integer.parseInt(S.substring(start, end))));

                symbol = end;
            }
            end++;
        }

        int n = list.size();
        preorder = list.toArray(new Node[n]);
        inorder = new Node[n];

        // 获取中序遍历
        int idx = 0;
        LinkedList<Node> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            if (stack.isEmpty() || stack.peek().level < node.level) {
                // 左子树的情况
                stack.push(node);
            } else {
                while (stack.peek().level >= node.level) {
                    inorder[idx++] = stack.poll();
                }
                // 右子树的情况
                // note: 在这里已经明确当该节点分别是其父节点的左右子树时放置的位置
                // 可以利用该信息，而不需要特别构造中序数组，重复计算
                inorder[idx++] = stack.poll();
                stack.push(node);
            }
        }

        while (!stack.isEmpty()) {
            inorder[idx++] = stack.poll();
        }

        Map<Node, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }

    private TreeNode buildTree(Node[] preorder, int preS, int preE, Node[] inorder, int inS, int inE, Map<Node, Integer> map) {
        if (preS > preE) {
            return null;
        } else if (preS == preE) {
            return new TreeNode(preorder[preS].value);
        }

        TreeNode root = new TreeNode(preorder[preS].value);
        int mid = map.get(preorder[preS]);
        root.left = buildTree(preorder, preS + 1, preS + mid - inS, inorder, inS, mid - 1, map);
        root.right = buildTree(preorder, preE - inE + mid + 1, preE, inorder, mid + 1, inE, map);

        return root;
    }

    private boolean isNumber(char ch) {
        return ch <= '9' && ch >= '0';
    }

    class Node {
        int level;
        int value;

        public Node(int level, int value) {
            this.level = level;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "level=" + level +
                    ", value=" + value +
                    '}';
        }
    }
}
