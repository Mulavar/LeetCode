/**
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
