/**
 * @author Lam
 * @ClassName P4MertArrays
 * @date 2020/1/19
 */
public class P4MedianTwoSortedArrays {
    class Solution {
        //note: 先归并两个数组再直接计算中位数，时间复杂度O(m+n)，空间复杂度O(m+n)
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

            return P4MedianTwoSortedArrays.findMedian(merged);

        }

    }

    class Solution1 {
        //note：直接逐个元素比较计算中位数，时间复杂度O(m+n)，空间复杂度O(1)
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0) {
                return P4MedianTwoSortedArrays.findMedian(nums2);
            }

            if (nums2.length == 0) {
                return P4MedianTwoSortedArrays.findMedian(nums1);
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
                return P4MedianTwoSortedArrays.findMedian(nums2, k2, k, m, even, nums1[k1 - 1]);
            } else if (k2 == len2) {
                return P4MedianTwoSortedArrays.findMedian(nums1, k1, k, m, even, nums2[k2 - 1]);
            } else {
                if (even) {
                    if (nums1[k1] < nums2[k2]) {
                        return P4MedianTwoSortedArrays.calcMedian(nums1, nums2, k1, k2);
                    } else {
                        return P4MedianTwoSortedArrays.calcMedian(nums2, nums1, k2, k1);
                    }
                } else {
                    return (nums1[k1] < nums2[k2]) ? nums1[k1] : nums2[k2];
                }
            }
        }

    }

    static double calcMedian(int[] nums1, int[] nums2, int k1, int k2) {
        int up = nums1[k1];
        if (k1 > 0 && k2 > 0) {
            return (double) (up + Math.max(nums1[k1 - 1], nums2[k2 - 1])) / 2;
        } else if (k1 > 0) {
            return (double) (up + nums1[k1 - 1]) / 2;
        } else {
            return (double) (up + nums2[k2 - 1]) / 2;
        }
    }

    static double findMedian(int[] nums, int k, int cnt, int m, boolean even, int down) {
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

    static double findMedian(int[] nums) {
        int m = nums.length / 2;
        boolean even = nums.length % 2 == 0;
        if (even) {
            return (double) (nums[m] + nums[m - 1]) / 2;
        } else {
            return nums[m];
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new P4MedianTwoSortedArrays().new Solution1();
        int[] nums1 = new int[]{1, 4, 5, 6};
        int[] nums2 = new int[]{2, 3};
        System.out.println(solution1.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[]{1, 3, 4, 5};
        nums2 = new int[]{2};
        System.out.println(solution1.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[]{1, 2, 4, 5};
        nums2 = new int[]{3};
        System.out.println(solution1.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[]{1, 2, 4, 5, 6};
        nums2 = new int[]{7};
        System.out.println(solution1.findMedianSortedArrays(nums1, nums2));
        nums1 = new int[]{1, 2, 5, 6, 7};
        nums2 = new int[]{4};
        System.out.println(solution1.findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1, 2, 4, 5, 7, 8};
        nums2 = new int[]{3, 6};
        System.out.println(solution1.findMedianSortedArrays(nums1, nums2));

    }

}
