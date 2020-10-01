/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * @author Lam
 * @ClassName P4MertArrays
 * @date 2020/1/19
 */
public class P4MedianTwoSortedArrays {
    /**
     * 先归并两个数组再直接计算中位数，时间复杂度O(m+n)，空间复杂度O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int k1 = 0;
        int k2 = 0;
        int k = 0;
        while (k1 < nums1.length && k2 < nums2.length) {
            if (nums1[k1] < nums2[k2]) {
                merged[k++] = nums1[k1++];
            } else {
                merged[k++] = nums2[k2++];
            }
        }

        while (k1 < nums1.length) {
            merged[k++] = nums1[k1++];
        }

        while (k2 < nums2.length) {
            merged[k++] = nums2[k2++];
        }

        return findMedian(merged);

    }


    /**
     * 直接逐个元素比较计算中位数，时间复杂度O(m+n)，空间复杂度O(1)
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return findMedian(nums2);
        }

        if (nums2.length == 0) {
            return findMedian(nums1);
        }

        int k1 = 0;
        int k2 = 0;
        int k = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int allLen = len1 + len2;
        int m = allLen / 2;
        boolean even = allLen % 2 == 0;

        while (k1 < len1 && k2 < len2 && k < m) {
            if (nums1[k1] < nums2[k2]) {
                k1++;
            } else {
                k2++;
            }
            k++;
        }

        if (k1 == len1) {
            return findMedian(nums2, k2, k, m, even, nums1[k1 - 1]);
        } else if (k2 == len2) {
            return findMedian(nums1, k1, k, m, even, nums2[k2 - 1]);
        } else {
            if (even) {
                // 数组总个数是偶数的情况，需要计算平均值
                if (nums1[k1] < nums2[k2]) {
                    return calcMedian(nums1, nums2, k1, k2);
                } else {
                    return calcMedian(nums2, nums1, k2, k1);
                }
            } else {
                return (nums1[k1] < nums2[k2]) ? nums1[k1] : nums2[k2];
            }
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if (n % 2 == 0) {
            return (getKthNum(nums1, 0, nums2, 0, n / 2 - 1) + getKthNum(nums1, 0, nums2, 0, n / 2)) / 2;
        } else {
            return getKthNum(nums1, 0, nums2, 0, n / 2);
        }
    }

    /**
     * 找两个数组有序合并后的下标为k的数字，
     * 基本思想：
     * 每次比较ln + (k-1)/2的数字，排除一部分并递归
     */
    private double getKthNum(int[] nums1, int l1, int[] nums2, int l2, int k) {
        // 其中一个数组排除完
        if (l1 >= nums1.length) {
            return nums2[l2 + k];
        }

        if (l2 >= nums2.length) {
            return nums1[l1 + k];
        }

        // k==0 递归结束
        if (k == 0) {
            return nums1[l1] < nums2[l2] ? nums1[l1] : nums2[l2];
        }

        int r1 = Math.min(nums1.length - 1, l1 + (k - 1) / 2);
        int r2 = Math.min(nums2.length - 1, l2 + (k - 1) / 2);
        if (nums1[r1] < nums2[r2]) {
            // 排除nums1[l1:r1]部分
            return getKthNum(nums1, r1 + 1, nums2, l2, k - (r1 - l1 + 1));
        } else {
            // 排除nums2[l2:r2]部分
            return getKthNum(nums1, l1, nums2, r2 + 1, k - (r2 - l2 + 1));
        }
    }

    private double calcMedian(int[] nums1, int[] nums2, int k1, int k2) {
        int up = nums1[k1];
        if (k1 > 0 && k2 > 0) {
            return (double) (up + Math.max(nums1[k1 - 1], nums2[k2 - 1])) / 2;
        } else if (k1 > 0) {
            return (double) (up + nums1[k1 - 1]) / 2;
        } else {
            return (double) (up + nums2[k2 - 1]) / 2;
        }
    }

    private double findMedian(int[] nums, int k, int cnt, int m, boolean even, int down) {
        while (cnt++ < m) {
            k++;
        }
        if (even) {
            if (k > 0) {
                down = (down > nums[k - 1]) ? down : nums[k - 1];
            }
            return (double) (nums[k] + down) / 2;
        } else {
            return nums[k];
        }
    }

    private double findMedian(int[] nums) {
        int m = nums.length / 2;
        boolean even = nums.length % 2 == 0;
        if (even) {
            return (double) (nums[m] + nums[m - 1]) / 2;
        } else {
            return nums[m];
        }
    }
}
