package jzoffer;

/**
 * @author Lam
 * @ClassName P51
 * @date 2020/5/28
 */
public class P51 {
    int pairs = 0;

    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length-1);
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

    public static void main(String[] args) {
        int[] nums = {
                3, 2, 4, 6, 5, 1
        };

        System.out.println(new P51().reversePairs(nums));
    }
}
