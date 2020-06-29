package jzoffer;

import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，
 * 其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * @author Lam
 * @date 2020/6/29
 */
public class P60 {
    public double[] twoSum(int n) {
        double[][] count = new double[n+1][6 * n + 1];
        double[] result = new double[5 * n + 1];
        //init
        for (int i = 1; i <= 6; i++) {
            count[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            count[i][i] = 1;
            for (int j = i + 1; j <= 6 * i; j++) {
                for (int k = 1; k <= 6 && j > k; k++) {
                    count[i][j] += count[i - 1][j - k];
                }
            }
        }

        System.out.println(Arrays.deepToString(count));
        for (int i = n; i <= 6 * n; i++) {
            result[i - n] = count[n][i] / Math.pow(6, n);
        }
        return result;
    }
}
