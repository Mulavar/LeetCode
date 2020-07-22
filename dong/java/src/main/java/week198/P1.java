package week198;

/**
 * @author Lam
 * @date 2020/7/19
 */
public class P1 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int remained = numBottles;
        int result = 0;
        while (remained >= numExchange) {
            // 能换的空瓶
            int temp = remained/ numExchange;
            result += remained - remained % numExchange;
            remained = remained % numExchange + temp;
            System.out.println("aa:" + remained);

        }

        System.out.println(remained);
        result += remained;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P1().numWaterBottles(9, 3));
    }
}
