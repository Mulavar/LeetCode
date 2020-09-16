import bean.FenwickTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
 * counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * @author Lam
 * @date 2020/5/31
 */
public class P315CountSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Node[] nodes = new Node[n];

        // 预处理原数组
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums[i], i);
        }

        merge(nodes, 0, n - 1, result);
        ArrayList<Integer> list = new ArrayList<>();
        for (int r : result) {
            list.add(r);
        }
        return list;
    }

    /**
     * 归并思想计算右侧小于当前元素的元素个数
     */
    private void merge(Node[] nodes, int left, int right, int[] result) {
        if (right <= left) {
            return;
        }

        int mid = left + (right - left) / 2;
        merge(nodes, left, mid, result);
        merge(nodes, mid + 1, right, result);

        int i = left;
        int j = mid + 1;
        int k = 0;
        Node[] tmp = new Node[right - left + 1];
        // 和计算逆序对相似(jzoffer P51)
        while (i <= mid && j <= right) {
            if (nodes[i].val <= nodes[j].val) {
                result[nodes[i].index] += j - mid - 1;
                tmp[k++] = nodes[i++];
            } else {
                tmp[k++] = nodes[j++];
            }
        }

        while (i <= mid) {
            result[nodes[i].index] += right - mid;
            tmp[k++] = nodes[i++];
        }

        while (j <= right) {
            tmp[k++] = nodes[j++];
        }

        for (i = left, k = 0; i <= right; i++) {
            nodes[i] = tmp[k++];
        }

    }

    /**
     * 树状数组思想
     */
    public List<Integer> countSmaller1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] ranks = new int[n];
        List<Integer> result = new ArrayList<>();
        System.arraycopy(nums, 0, ranks, 0, n);
        Arrays.sort(ranks);
        int r = 1;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(ranks[i])) {
                map.put(ranks[i], r++);
            }
        }

        System.out.println(map);

        FenwickTree tree = new FenwickTree(n);

        // 逆序插入，对nums[i]查询在[i + 1, nums.length-1]范围小于nums[i]的元素个数
        for (int i = n - 1; i >= 0; i--) {
            int idx = map.get(nums[i]);
            tree.update(idx, 1);
            result.add(0, tree.query(idx - 1));
        }
        return result;
    }

    class Node {
        int val;

        /**
         * 记录该元素原先位置
         */
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
