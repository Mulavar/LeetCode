/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * @author Lam
 * @date 2020/7/22
 */
public class P231PowerTwo {
    public boolean isPowerOfTwo(int n) {
        int result = 0;

        // 找出1的数目
        while (n > 0) {
            if ((n & 1) != 0) {
                result++;
            }
            n >>= 1;
        }
        return result == 1;
    }
}
