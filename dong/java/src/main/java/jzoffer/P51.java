package jzoffer;

import bean.FenwickTree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * @author Lam
 * @ClassName P51
 * @date 2020/5/28
 */
public class P51 {
    int pairs = 0;

    /**
     * 使用归并思想计算逆序和
     */
    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return pairs;
    }

    private void merge(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = left + (right - left) / 2;
        merge(nums, left, mid);
        merge(nums, mid + 1, right);

        int k = 0;
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;

        // 双指针扫描
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                // 左边指针的值>右边指针的值
                pairs += (mid - i + 1);
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        k = 0;
        for (i = left; i <= right; i++) {
            nums[i] = tmp[k++];
        }
    }

    public int reversePairs1(int[] nums) {
        int rank = 1;
        int n = nums.length;

        // 辅助数组
        int[] ranks = new int[n];
        System.arraycopy(nums, 0, ranks, 0, n);
        Arrays.sort(ranks);

        // 利用辅助数组记录每个元素的实际的相对大小顺序
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r : ranks) {
            if (!map.containsKey(r)) {
                map.put(r, rank++);
            }
        }

        // 假设有一个数组 arr,
        // 我们逆序遍历数组，对每个数的排名 r 做 arr[r]++
        // 查找逆序对的问题就变成了对每个 r 计算 sum(arr[1...r-1])
        // 即计算前缀和的问题
        // 引入树状数组快速更新单点，并计算前缀和
        FenwickTree tree = new FenwickTree(nums.length);
        int result = 0;

        // 逆序插入，对nums[i]查询在[i + 1, nums.length-1]范围小于nums[i]的元素个数
        for (int i = nums.length - 1; i >= 0; i--) {
            // 插入排名代替实际的值
            int r = map.get(nums[i]);
            // 查询比当前排名小的数有几个
            result += tree.query(r - 1);
            // 该排名对应位置 + 1
            tree.update(r, 1);
        }

        return result;
    }

}
