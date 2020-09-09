package bean;

/**
 * 树状数组
 *
 * @author Lam
 * @date 2020/6/1
 */
public class FenwickTree {
    /**
     * 树状数组，从1开始计数
     */
    int[] tree;

    /**
     * 数组长度
     */
    int n;

    public FenwickTree(int n) {
        this.n = n + 1;
        this.tree = new int[this.n];
    }

    /**
     * 单点更新树状数组
     *
     * @param i 第i个位置
     * @param x 增加x
     */
    public void update(int i, int x) {
        while (i < n) {
            tree[i] += x;
            i += lowBit(i);
        }
    }

    /**
     * 查找[1, n]位置的前缀和
     *
     * @param i 第i个位置
     * @return 前缀和
     */
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowBit(i);
        }

        return sum;
    }

    private int lowBit(int a) {
        return a & (-a);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        FenwickTree tree = new FenwickTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            tree.update(i+1, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(tree.query(i+1) + " ");
        }

        tree.update(1, 2);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(tree.query(i+1) + " ");
        }
    }
}
