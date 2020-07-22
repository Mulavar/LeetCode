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

        // pre = first = (0, i-1)
        for (int i = 1; i <= num.length() - 2; i++) {

            // cur = second = (i, j-1)
            for (int j = i + 1; j <= num.length() - 1; j++) {
                int k = j;
                pre = num.substring(0, i);
                cur = num.substring(i, k);

                // 前缀为0的数字不合格，全部跳出
                // pre可以考虑直接返回false
                if (pre.length() > 1 && pre.charAt(0) == '0') {
                    break;
                }

                if (cur.length() > 1 && cur.charAt(0) == '0') {
                    break;
                }


                next = new BigInteger(pre).add(new BigInteger(cur)).toString();

                // 不断往后遍历，找下一个累加和
                while (next.length() < num.length() - k && num.startsWith(next, k)) {
                    pre = cur;
                    cur = next;
                    k += next.length();
                    next = new BigInteger(pre).add(new BigInteger(cur)).toString();
                }

                // 遍历到最后一位，确定为累加数
                if (next.length() == num.length() - k && num.startsWith(next, k)) {
                    return true;
                } else if (next.length() > num.length() - k) {
                    break;
                }
            }
        }
        return false;
    }
}
