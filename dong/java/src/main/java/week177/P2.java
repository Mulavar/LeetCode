package week177;

/**
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 *
 * @author Lam
 * @ClassName P2
 * @date 2020/2/23
 */
public class P2 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n == 0) {
            return true;
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        boolean result = isValid(visited, leftChild[0], leftChild, rightChild) && isValid(visited, rightChild[0], leftChild, rightChild);
        if (result) {
            for (int i=0;i<n;i++) {
                if (!visited[i]) {
                    return false;
                }
            }
        }
        return result;
    }

    private boolean isValid(boolean[] visited, int idx, int[] leftChild, int[] rightChild) {
        if (idx == -1) {
            return true;
        }
        if (visited[idx]) {
            return false;
        }

        visited[idx] = true;
        return isValid(visited, leftChild[idx], leftChild, rightChild) && isValid(visited, rightChild[idx], leftChild, rightChild);
    }
}
