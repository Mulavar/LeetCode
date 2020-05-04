/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * Tips: 考察快速幂以及边界输入输出，主要是Integer.MIN_VALUE
 * @author Lam
 * @date 2020/5/1
 */
public class P50PowxN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        x = n > 0 ? x : 1 / x;
        n = n > 0 ? n : -n;
        double result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P50PowxN().myPow(2, Integer.MIN_VALUE));
    }
}
