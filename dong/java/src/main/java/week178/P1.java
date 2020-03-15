package week178;

import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P1
 * @date 2020/3/1
 */
public class P1 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[110];
        int[] result = new int[nums.length];
        for (int num : nums) {
            count[num]++;
        }

        int preCount = 0;
        for (int i = 100; i >= 0; i--) {
            if (count[i] != 0) {
                preCount += count[i];
                count[i] = nums.length - preCount;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = count[nums[i]];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,1,2,2,3};
        System.out.println(Arrays.toString(new P1().smallerNumbersThanCurrent(nums)));
    }
}
