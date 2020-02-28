/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * <p>
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 * @author Lam
 * @ClassName P507
 * @date 2020/2/28
 */
public class P507PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1;
        int i = 2;
        int sqrt = (int) Math.sqrt(num);
        while (i < sqrt) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
            i++;
        }

        if (num%sqrt==0) {
            sum += sqrt;
            if (sqrt * sqrt != num) {
                sum += num/sqrt;
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(new P507PerfectNumber().checkPerfectNumber(6));
    }
}
