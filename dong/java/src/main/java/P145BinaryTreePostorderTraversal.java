import bean.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * @author Lam
 * @ClassName P145BinaryTreePostorderTraversal
 * @date 2020/2/22
 */
public class P145BinaryTreePostorderTraversal {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            postorder(result, root);
            return result;
        }

        private void postorder(List<Integer> result, TreeNode root) {
            if (root == null) {
                return;
            }
            postorder(result, root.left);
            postorder(result, root.right);
            result.add(root.val);
        }
    }

    class Solution1 {
        /**
         * 用一个set标记是否访问过左子树
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            HashSet<TreeNode> visited = new HashSet<>();
            ArrayList<Integer> result = new ArrayList<>();

            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                p = stack.peek();
                if (visited.add(p)) {
                    // 之前不在set里，则表示刚访问完左子树
                    p = p.right;
                } else {
                    result.add(p.val);
                    stack.pop();
                    p = null;
                }
            }

            return result;
        }

        class Solution2 {
            /**
             * 双栈法1：
             * 将所有节点按中、右、左的顺序入栈2，
             * 则2出栈顺序即为后续遍历。
             * <p>
             * 中、右、左的遍历可以使用栈1利用先序遍历的思想
             */
            public List<Integer> postorderTraversal(TreeNode root) {
                Stack<TreeNode> stack = new Stack<>();
                Stack<TreeNode> out = new Stack<TreeNode>();
                ArrayList<Integer> result = new ArrayList<>();

                TreeNode node = root;

                while (node != null || !stack.isEmpty()) {
                    while (node != null) {
                        stack.push(node);
                        out.push(node);
                        node = node.right;
                    }

                    node = stack.pop();
                    node = node.left;
                }

                while (!out.isEmpty()) {
                    result.add(out.pop().val);
                }
                return result;
            }

            /**
             * **************
             * 双栈法2：
             * 将所有节点按中、右、左的顺序入栈2，
             * 则2出栈顺序即为后续遍历。
             * <p>
             * 中、右、左的顺序可以使用栈1得到，
             * 栈中先插入root，
             * 每次pop得到root并push root.left和root.right，
             * 这样每次pop顺序就是中、右、左。
             * **************
             */
            public List<Integer> postorderTraversal1(TreeNode root) {
                Stack<TreeNode> stack = new Stack<>();
                Stack<TreeNode> out = new Stack<TreeNode>();
                ArrayList<Integer> result = new ArrayList<>();

                TreeNode node = root;
                if (node != null) {
                    stack.push(node);
                }
                while (!stack.isEmpty()) {
                    node = stack.pop();
                    out.push(node);
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }

                while (!out.isEmpty()) {
                    result.add(out.pop().val);
                }
                return result;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new P145BinaryTreePostorderTraversal().new Solution1().postorderTraversal(root);
    }
}
