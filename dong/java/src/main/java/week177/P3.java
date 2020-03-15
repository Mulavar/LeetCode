package week177;

/**
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 * <p>
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 *
 * @author Lam
 * @ClassName P3
 * @date 2020/2/23
 */
public class P3 {
    public int[] closestDivisors(int num) {
        int[] factor1 = findMinimumFactorSub(num + 1);
        int[] factor2 = findMinimumFactorSub(num + 2);

        return factor1[1] - factor1[0] <= factor2[1] - factor2[0] ? factor1 : factor2;
    }

    private int[] findMinimumFactorSub(int num) {
        int mid = (int) Math.sqrt(num);
        int[] factors = new int[2];
        for (; mid >= 1; mid--) {
            if (num % mid == 0) {
                factors[0] = mid;
                factors[1] = num / mid;
                break;
            }
        }
        return factors;
    }
}
