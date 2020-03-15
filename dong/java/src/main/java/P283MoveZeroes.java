import java.util.Arrays;

/**
 * @author Lam
 * @ClassName P283MoveZeroes
 * @date 2020/1/29
 */
public class P283MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;
            int cnt = 0;
            while (i < nums.length) {
                while (i < nums.length && nums[i] == 0) {
                    i++;
                }
                if (i == nums.length) {
                    break;
                }
                int tmp = nums[i];
                nums[i++] = nums[cnt];
                nums[cnt++] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new P283MoveZeroes().new Solution().moveZeroes(nums);
    }
}
