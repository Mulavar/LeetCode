package week198;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @date 2020/7/19
 */
public class P4 {
    public int closestToTarget(int[] arr, int target) {
        int result = Integer.MAX_VALUE;
        int n = arr.length;

        List<Integer> list = new ArrayList<>();

        // 去掉重复元素
        // 缺少这一步会超时
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int ans = list.get(i);
            for (int j = i; j < list.size(); j++) {
                ans &= list.get(j);
                result = Math.min(result, Math.abs(ans - target));

                // 利用a&b<=a的特性，若ans小于target，后续的ans都会更小，
                // 不必多余计算
                if (ans < target) {
                    break;
                }
            }
        }
        return result;
    }

    public int closestToTarget1(int[] arr, int target) {
        int result = Integer.MAX_VALUE;
        int n = arr.length;

        SegmentTreeNode root = SegmentTree.build(arr, 0, n - 1);

        int l = 0;
        int r = 0;

        while (r < n) {
            // 每次查询区间运算和
            int cur = SegmentTree.query(root, l, r);

            // 更新结果
            result = Math.min(result, Math.abs(cur - target));

            if (cur == target) {
                return 0;
            }
            // 如果结果较小，则左指针右移
            else if (cur < target) {
                l++;
                r = Math.max(l, r);
            } else {
                r++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P4().closestToTarget(new int[]{9, 12, 3, 7, 15}, 5));
        System.out.println(new P4().closestToTarget(new int[]{5, 89, 79, 44, 79}, 965));
        System.out.println(new P4().closestToTarget1(new int[]{5, 89, 79, 44, 79}, 965));
        System.out.println(new P4().closestToTarget1(new int[]{9, 12, 3, 7, 15}, 5));
    }
}


/**
 * 线段树结点
 */
class SegmentTreeNode {
    /**
     * 区间开始
     */
    int start;

    /**
     * 区间结束
     */
    int end;

    /**
     * 区间运算和
     */
    int value;

    /**
     * 左子树
     */
    SegmentTreeNode left;

    /**
     * 右子树
     */
    SegmentTreeNode right;

    public SegmentTreeNode(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

}

class SegmentTree {
    /**
     * 针对数组建立对应的线段树
     */
    public static SegmentTreeNode build(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end, arr[start]);
        }

        int mid = start + (end - start) / 2;

        // 建立子树
        SegmentTreeNode leftTree = build(arr, start, mid);
        SegmentTreeNode rightTree = build(arr, mid + 1, end);

        SegmentTreeNode tree = new SegmentTreeNode(start, end, leftTree.value & rightTree.value);
        tree.left = leftTree;
        tree.right = rightTree;

        return tree;
    }

    /**
     * 查询某区间运算和
     */
    public static int query(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && end >= root.end) {
            return root.value;
        }

        int mid = root.start + (root.end - root.start) / 2;

        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start > mid) {
            return query(root.right, start, end);
        } else {
            return query(root.left, start, mid) & query(root.right, mid + 1, end);
        }

    }
}