import java.util.Arrays;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * @author Lam
 * @ClassName P260SingleNumberIII
 * @date 2020/2/25
 */
public class P260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s ^= num;
        }

        // 得到s最右边的1（这个1表示两个只出现一次的元素不同的位置）  1100 & 0100 = 0100
        s = s & -s;

        int a = 0;
        int b = 0;

        // 将nums分为两组，
        for (int num : nums) {
            if ((num & s) == s) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,2,5};
        System.out.println(Arrays.toString(new P260SingleNumberIII().singleNumber(nums)));
    }
}
