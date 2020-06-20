package jzoffer;

import java.util.Arrays;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * @author Lam
 * @date 2020/6/20
 */
public class P56_2 {
    public int singleNumber(int[] nums) {
        int[] ranks = new int[32];
        for (int num : nums) {
            int k = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    ranks[31 - k] = (ranks[31 - k] + 1) % 3;
                }
                num >>= 1;
                k++;
            }
        }

        int result = 0;
        for (int rank : ranks) {
            result = (result * 2) + rank;
        }

        return result;
    }

    /**
     * 有限状态机，某一位数字出现次数共有三种状态，0、1、2，
     * 表示成二进制分别是00、01、10，
     * 用变量twos表示每一位数字出现次数的高位集合
     * 用变量ones表示每一位数字出现次数的低位集合
     * 由于题目要求只出现一次的数字，所以最后twos一定是0
     * 返回ones即可
     */
    public int singleNumber1(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }

        return ones;
    }
}
