/**
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 * <p>
 * 丑数是可以被 a 或 b 或 c 整除的 正整数。
 *
 * @author Lam
 * @ClassName P1201UglyNumberIII
 * @date 2020/2/28
 */
public class P1201UglyNumberIII {
    /**
     * 给定n，右边界确定，对边界中每个数k计算小于k的个数
     */
    public int nthUglyNumber(int n, int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int right = Math.min(min * n, (int) 2e9);
        int left = min;
        while (left < right) {
            //防止溢出
            int mid = left + (right - left) / 2;
            int k = calcLess(mid, a, b, c);
            if (k < n) {
                left = mid + 1;
            } else if (k > n) {
                right = mid;
            } else {
                return mid - Math.min(mid % a, Math.min(mid % b, mid % c));
            }
        }
        return left;
    }

    private int calcLess(int num, int a, int b, int c) {
        return (int)(num / a + num / b + num / c - num / lcm(a, b) - num / lcm(a, c) - num / lcm(b, c) + num / lcm(lcm(a, b), c));
    }

    private long gcd(long m, long n) {
        if (n == 0) {
            return m;
        }
        return m > n ? gcd(n, m % n) : gcd(m, n % m);
    }

    private long lcm(long m, long n) {
        // 需要注意溢出
        return m * (n / gcd(m, n));
    }

    public static void main(String[] args) {
        System.out.println(new P1201UglyNumberIII().nthUglyNumber(1000000000, 2, 217983653, 336916467));
        System.out.println(new P1201UglyNumberIII().nthUglyNumber(100, 2, 3, 5));

        System.out.println(new P1201UglyNumberIII().calcLess(1999999984, 2, 217983653, 336916467));
    }
}
