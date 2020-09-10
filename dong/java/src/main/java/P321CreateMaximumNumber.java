import java.util.LinkedList;

/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * @author Lam
 * @ClassName P321CreateMaximumNumber
 * @date 2020/8/18
 */
public class P321CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];

        // i 表示取几位nums1的子序列
        for (int i = Math.max(0, k - nums2.length); i <= k && i <= nums1.length; i++) {
            // 从nums1中获取i位的最大子序列
            int[] sub1 = getLargestSubSequence(nums1, i);
            // 剩下的k-i从nums2中获取
            int[] sub2 = getLargestSubSequence(nums2, k - i);


            int[] cur = new int[k];
            int idx1 = 0;
            int idx2 = 0;
            int newIdx = 0;

            // 不能简单的用归并，需要考虑碰到相等数字的情况
            // 如 2, 5, 6, 4, 4, 0
            // 和 7, 3, 8, 0, 6, 5, 7, 6, 2
            while (idx1 < sub1.length || idx2 < sub2.length) {
                if (idx1 == sub1.length) {
                    cur[newIdx++] = sub2[idx2++];
                } else if (idx2 == sub2.length) {
                    cur[newIdx++] = sub1[idx1++];
                } else {
                    if (sub1[idx1] < sub2[idx2]) {
                        cur[newIdx++] = sub2[idx2++];
                    } else if (sub1[idx1] > sub2[idx2]) {
                        cur[newIdx++] = sub1[idx1++];
                    } else {
                        // 考虑相等，需要比较后面的
                        int tmp1 = idx1 + 1;
                        int tmp2 = idx2 + 1;
                        int flag = 0;
                        while (tmp1 < sub1.length && tmp2 < sub2.length) {
                            if (sub1[tmp1] < sub2[tmp2]) {
                                flag = 2;
                                break;
                            } else if (sub1[tmp1] > sub2[tmp2]) {
                                flag = 1;
                                break;
                            }
                            tmp1++;
                            tmp2++;
                        }

                        if (flag == 0) {
                            // 都一样，比较谁长
                            if (tmp1 < sub1.length) {
                                flag = 1;
                            } else {
                                flag = 2;
                            }
                        }

                        if (flag == 1) {
                            cur[newIdx++] = sub1[idx1++];
                        } else {
                            cur[newIdx++] = sub2[idx2++];
                        }

                    }
                }
            }

            for (int j = 0; j < k; j++) {
                if (cur[j] < result[j]) {
                    break;
                } else if (cur[j] > result[j]) {
                    result = cur;
                    break;
                }
            }

        }

        return result;
    }

    /**
     * 获取k位最大子序列
     *
     * @param nums
     * @param k    保留k位
     * @return
     */
    private int[] getLargestSubSequence(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (count < n - k && !list.isEmpty() && list.peekLast() < nums[i]) {
                list.removeLast();
                count++;
            }
            list.addLast(nums[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
