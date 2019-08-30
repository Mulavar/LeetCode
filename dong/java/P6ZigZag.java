public class P6ZigZag {
    class Solution {
        public String convert(String s, int numRows) {
            StringBuilder result = new StringBuilder();
            if (numRows == 1 || s.length() <= 1) {
                return s;
            }

            int interval = 2 * (numRows - 1);
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j * interval < s.length(); j++) {
                    if (j * interval + i < s.length()) {
                        result.append(s.charAt(j * interval + i));
                    }

                    if (i > 0 && 2 * i < interval && (j + 1) * interval - i < s.length()) {
                        result.append(s.charAt((j + 1) * interval - i));
                    }
                }
            }
            return result.toString();
        }
    }
}