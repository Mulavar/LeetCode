/**
 * @author Lam
 * @date 2019/12/12
 */
public class P66PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int d = 1;
            int i = digits.length - 1;
            for (; i >= 0; i--) {
                if (d == 0) {
                    break;
                }
                d = (digits[i] + 1) / 10;
                digits[i] = (digits[i] + 1) % 10;
            }
            if (i < 0 && d == 1) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (i = 1; i < result.length; i++) {
                    result[i] = digits[i - 1];
                }
                return result;
            }
            return digits;
        }
    }
}
