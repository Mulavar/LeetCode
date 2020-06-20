package jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * @author Lam
 * @date 2020/6/20
 */
public class P57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        int l = 1;
        int r = 2;
        int sum = l + r;
        while (l <= target / 2) {
            if (sum == target) {
                int[] tmp = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    tmp[i - l] = i;
                }
                list.add(tmp);
                sum -= l++;
            } else if (sum < target) {
                sum += ++r;
            } else {
                sum -= l++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
