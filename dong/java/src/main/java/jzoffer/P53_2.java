package jzoffer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * @author Lam
 * @date 2020/6/20
 */
public class P53_2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n + 1) * n / 2;
        for (int num :
                nums) {
            sum -= num;
        }
        return sum;
    }
}
