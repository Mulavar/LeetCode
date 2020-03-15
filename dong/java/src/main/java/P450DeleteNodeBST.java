import bean.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * @author Lam
 * @ClassName P450DeleteNodeBST
 * @date 2020/2/10
 */
public class P450DeleteNodeBST {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key && root.left == null && root.right == null) {
                return null;
            }
            delete(null, root, key);
            return root;
        }

        private void delete(TreeNode parent, TreeNode current, int key) {
            if (current == null) {
                return;
            }

            if (current.val == key) {
                if (current.left == null && parent != null) {
                    parent.left = parent.left == current ? current.right : parent.left;
                    parent.right = parent.right == current ? current.right : parent.right;
                } else if (current.right == null && parent != null) {
                    parent.left = parent.left == current ? current.left : parent.left;
                    parent.right = parent.right == current ? current.left : parent.right;
                } else {
                    //可以优化为递归删除下一个节点
                    if (current.left != null) {
                        TreeNode tmpParent = current;
                        TreeNode tmp = current.left;
                        while (tmp.right != null) {
                            tmpParent = tmp;
                            tmp = tmp.right;
                        }
                        if (tmpParent == current) {
                            tmpParent.left = tmp.left;
                        } else {
                            tmpParent.right = tmp.left;
                        }
                        swap(current, tmp);
                    } else {
                        TreeNode tmpParent = current;
                        TreeNode tmp = current.right;
                        while (tmp.left != null) {
                            tmpParent = tmp;
                            tmp = tmp.left;
                        }
                        if (tmpParent == current) {
                            tmpParent.right = tmp.right;
                        } else {
                            tmpParent.left = tmp.right;
                        }
                        swap(current, tmp);
                    }

                }
                return;
            }

            if (key < current.val) {
                delete(current, current.left, key);
            } else {
                delete(current, current.right, key);
            }
        }

        private void swap(TreeNode n1, TreeNode n2) {
            int tmp = n1.val;
            n1.val = n2.val;
            n2.val = tmp;
        }
    }

    class Solution1 {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left != null) {
                    TreeNode node = root.left;
                    while (node.right != null) {
                        node = node.right;
                    }
                    root.val = node.val;
                    root.left = deleteNode(root.left, root.val);
                } else {
                    TreeNode node = root.right;
                    while (node.left != null) {
                        node = node.left;
                    }
                    root.val = node.val;
                    root.right = deleteNode(root.right, root.val);
                }
            } else if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }

            return root;
        }

        private void swap(TreeNode n1, TreeNode n2) {
            int tmp = n1.val;
            n1.val = n2.val;
            n2.val = tmp;
        }
    }
}
