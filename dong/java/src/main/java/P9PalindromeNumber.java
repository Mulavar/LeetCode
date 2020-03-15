public class P9PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            } else if (x == 0) {
                return true;
            }

            String number = String.valueOf(x);
            int len = number.length();
            for (int i = 0; i <= len / 2; i++) {
                if (number.charAt(i) != number.charAt(len - i - 1)) {
                    return false;
                }
            }

            return true;
        }
    }
}