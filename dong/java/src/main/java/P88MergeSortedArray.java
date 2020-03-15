import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P88MergeSortedArray
 * @date 2020/1/29
 */
public class P88MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int idx = nums1.length - 1;
            while (idx >= 0) {
                int num1 = m > 0 ? nums1[m - 1] : Integer.MIN_VALUE;
                int num2 = n > 0 ? nums2[n - 1] : Integer.MIN_VALUE;
                if (num1 > num2) {
                    nums1[idx--] = num1;
                    m--;
                } else {
                    nums1[idx--] = num2;
                    n--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new P88MergeSortedArray().new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
