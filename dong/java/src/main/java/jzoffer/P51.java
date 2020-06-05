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
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
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
        int[] ranks = new int[n];
        System.arraycopy(nums, 0, ranks, 0, n);
        Arrays.sort(ranks);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r : ranks) {
            if (!map.containsKey(r)) {
                map.put(r, rank++);
            }
        }

        FenwickTree tree = new FenwickTree(nums.length);
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int r = map.get(nums[i]);
            result += tree.query(r - 1);
            tree.update(r, 1);
        }

        return result;
    }

}
