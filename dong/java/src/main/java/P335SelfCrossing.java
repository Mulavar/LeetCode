/**
 * 给定一个含有 n 个正数的数组 x。从点 (0,0) 开始，先向北移动 x[0] 米，然后向西移动 x[1] 米，向南移动 x[2] 米，向东移动 x[3] 米，持续移动。
 * 也就是说，每次移动后你的方位会发生逆时针变化。
 * 编写一个 O(1) 空间复杂度的一趟扫描算法，判断你所经过的路径是否相交。
 *
 * @author Lam
 * @date 2020/7/24
 */
public class P335SelfCrossing {
    /**
     * 分析所有相交情况的判断条件
     */
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) {
            return false;
        }

        int n = x.length;

        for (int i = 3; i < n; i++) {
            if (i >= 3 && x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) {
                return true;

            }

            if (i >= 4 && x[i - 3] == x[i - 1] && x[i] + x[i - 4] >= x[i - 2]) {
                return true;
            }

            if (i >= 5 && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] + x[i - 5] >= x[i - 3] && x[i - 2] > x[i - 4] && x[i - 3] > x[i - 1]) {
                return true;
            }
        }

        return false;
    }
}
