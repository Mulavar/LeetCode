/**
 * @author Lam
 * @ClassName P27RemoveElement
 * @date 2020/1/27
 */
public class P27RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    continue;
                }
                nums[cnt++] = nums[i];
            }
            return cnt;
        }
    }
}
