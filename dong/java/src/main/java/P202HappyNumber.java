import java.util.HashSet;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 *
 * @author Lam
 * @ClassName P202HappyNumber
 * @date 2020/2/28
 */
public class P202HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            n = next(n);
            if (n == 1) {
                return true;
            }
            if (!set.add(n)) {
                return false;
            }
        }
    }

    /**
     * 判断环都可以用快慢指针
     */
    public boolean isHappy1(int n) {
        int slow = next(n);
        int fast = next(next(n));
        while (slow != fast && fast != 1) {
            if (slow == fast) {
                return false;
            }
            slow = next(slow);
            fast = next(next(fast));
        }
        if (fast == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int next(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P202HappyNumber().isHappy(17));
    }
}
