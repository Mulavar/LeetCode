import java.math.BigInteger;

/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * @author Lam
 * @ClassName P306AdditiveNumber
 * @date 2020/2/27
 */
public class P306AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }

        String pre;
        String cur;
        String next;
        for (int i = 1; i < num.length() - 1; i++) {
            for (int j = i; j < num.length() - 1; j++) {
                int k = j;
                pre = num.substring(0, i);
                cur = num.substring(i, k + 1);
                next = new BigInteger(pre).add(new BigInteger(cur)).toString();
                System.out.println("i:" + i + ", j:" + j + ", pre:" + pre + ", cur:" + cur + ", next:" + next);
                while (next.length() < num.length() - k - 1 && num.substring(k + 1, k + 1 + next.length()).equals(next)) {
                    pre = cur;
                    cur = next;
                    k += next.length();
                    next = new BigInteger(pre).add(new BigInteger(cur)).toString();
                    System.out.println("i:" + i + ", j:" + j + ", pre:" + pre + ", cur:" + cur + ", next:" + next);
                }
                System.out.println("i:" + i + ", j:" + j + ", pre:" + pre + ", cur:" + cur + ", next:" + next);
                if (next.length() == num.length() - k - 1 && num.substring(k + 1, k + 1 + next.length()).equals(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new P306AdditiveNumber().isAdditiveNumber("112358"));
//        System.out.println(new P306AdditiveNumber().isAdditiveNumber("199100199"));
        System.out.println(new P306AdditiveNumber().isAdditiveNumber("1023"));
    }
}
