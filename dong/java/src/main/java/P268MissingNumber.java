/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * @author Lam
 * @ClassName P268MissingNumber
 * @date 2020/2/23
 */
public class P268MissingNumber {
    /**
     * 方法1：遍历
     */
    public int missingNumber(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int idx = nums[i] > length ? nums[i] - length - 1 : nums[i];
            if (idx < length) {
                nums[idx] += length + 1;
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] <= length) {
                return i;
            }
        }

        return length;
    }

    /**
     * 方法2：位运算
     */
    public int missingNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
            result ^= i;
        }
        result ^= nums.length;
        return result;
    }

    /**
     * 方法3：数学法
     */
    public int missingNumber2(int[] nums) {
        int result = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            result -= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0};
        System.out.println(new P268MissingNumber().missingNumber(nums));
    }
}
