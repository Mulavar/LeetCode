/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @author Lam
 * @ClassName P137SingleNumberII
 * @date 2020/2/21
 */
public class P137SingleNumberII {
    class Solution {
        /**
         * 对每一位的1计数，如果只出现一次的数在该位是1
         * 则计算出来的结果不能被3除尽。
         */
        public int singleNumber(int[] nums) {
            int sum = 0;
            int res = 0;
            for (int i = 0; i < 32; i++) {
                sum = 0;
                for (int j = 0; j < nums.length; j++) {
                    sum += nums[j] >> i & 1;
                }
                if (sum % 3 != 0) {
                    res += 1 << i;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 2, 3, 2};
        System.out.println(new P137SingleNumberII().new Solution().singleNumber(ints));
    }
}
