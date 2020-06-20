package jzoffer;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * @author Lam
 * @date 2020/6/20
 */
public class P56_1 {
    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        int k = 0;
        for (int num: nums) {
            k ^= num;
        }
//        System.out.println("K:" + k);
        int l = k & (-k);
//        System.out.println("l:" + l);
        int ans1 = 0;
        int ans2 = 0;
        for (int num: nums) {
            if ((num&l)==l) {
                ans1 ^= num;
            } else {
                ans2 ^= num;
            }
        }
        result[0] = ans1;
        result[1] = ans2;
        return result;
    }
}
