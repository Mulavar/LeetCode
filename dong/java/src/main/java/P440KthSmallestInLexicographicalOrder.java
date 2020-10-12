/**
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * @author Lam
 * @ClassName P440KthSmallestInLexicographicalOrder
 * @date 2020/10/11
 */
public class P440KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int start = 1;
        int pos = 1;

        while (pos < k) {
            int count = getCount(start, n);
            // 如 start 从 1->2
            // pos 需要增加 count
            if (count + pos <= k) {
                start++;
                pos += count;
            }
            // 如 start 从 1 -> 10
            // pos 只需增加 1
            else {
                start *= 10;
                pos++;
            }
        }
        return start;
    }

    /**
     * 计算[1,n]范围内前缀为prefix的数字个数
     */
    private int getCount(long prefix, long n) {
        long nextPrefix = prefix + 1;
        int count = 0;
        while (prefix <= n) {
            count += Math.min(nextPrefix, n + 1) - prefix;

            // 需要考虑prefix溢出，因此使用long
            prefix *= 10;
            nextPrefix *= 10;
        }

        return count;
    }
}
