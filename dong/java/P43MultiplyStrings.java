/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * <p>
 * Note:
 * 1.The length of both num1 and num2 is < 110.
 * 2.Both num1 and num2 contain only digits 0-9.
 * 3.Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * 4.You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @author Lam
 * @ClassName P43MultiplyStrings
 * @date 2020/2/3
 */
public class P43MultiplyStrings {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            String result = "0";
            int len = num2.length();
            int idx = len - 1;
            while (idx >= 0) {
                StringBuilder mul = mul(num1, num2.charAt(idx));
                int suffix = len - idx - 1;
                while (suffix > 0) {
                    mul.append("0");
                    suffix--;
                }
                idx--;
                result = add(result, mul.toString());
            }

            return result;
        }

        private StringBuilder mul(String num1, char num2) {
            int i = num1.length() - 1;
            int c = 0;
            StringBuilder result = new StringBuilder();

            while (i >= 0) {
                int m = num1.charAt(i) - '0';
                int tmp = m * (num2 - '0') + c;
                result.insert(0, tmp % 10);
                c = tmp / 10;
                i--;
            }

            if (c > 0) {
                result.insert(0, c);
            }

            return result;
        }

        private String add(String num1, String num2) {
            int idx1 = num1.length() - 1;
            int idx2 = num2.length() - 1;
            int c = 0;
            StringBuilder result = new StringBuilder();

            while (idx1 >= 0 && idx2 >= 0) {
                int m1 = num1.charAt(idx1) - '0';
                int m2 = num2.charAt(idx2) - '0';
                int tmp = m1 + m2 + c;
                c = tmp / 10;
                result.insert(0, tmp % 10);
                idx1--;
                idx2--;
            }

            while (idx1 >= 0) {
                int m = num1.charAt(idx1) - '0';
                int tmp = m + c;
                c = tmp / 10;
                result.insert(0, tmp % 10);
                idx1--;
            }

            while (idx2 >= 0) {
                int m = num2.charAt(idx2) - '0';
                int tmp = m + c;
                c = tmp / 10;
                result.insert(0, tmp % 10);
                idx2--;
            }

            if (c > 0) {
                result.insert(0, c);
            }

            return result.toString();
        }
    }

    class Solution1 {
        //优化方案：空间重用
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            int[] mul = new int[num1.length() + num2.length()];
            for (int i = num1.length() - 1; i >= 0; i--) {
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int tmp = mul[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    mul[i + j + 1] = tmp % 10;
                    mul[i + j] += tmp / 10;
                }
            }

            int start = 0;
            while (mul[start] == 0) {
                start++;
            }

            StringBuilder result = new StringBuilder();
            while (start < mul.length) {
                result.append(mul[start]);
                start++;
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new P43MultiplyStrings().new Solution().multiply(num1, num2));
    }
}
