/**
 * @author Lam
 * @date 2019/12/12
 */
public class P67AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            char x, y, z;
            z = '0';
            while (i >= 0 || j >= 0) {
                if (i < 0) {
                    x = '0';
                } else {
                    x = a.charAt(i);
                }
                if (j < 0) {
                    y = '0';
                } else {
                    y = b.charAt(j);
                }
                int cnt = count(x, y, z);
                if (cnt % 2 == 0) {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                }
                z = cnt >= 2 ? '1' : '0';
                i--;
                j--;
            }
            if (z == '1') {
                sb.insert(0, '1');
            }
            return sb.toString();

        }

        public int count(char x, char y, char z) {
            int cnt = 0;
            if (x == '1') {
                cnt++;
            }
            if (y == '1') {
                cnt++;
            }
            if (z == '1') {
                cnt++;
            }
            return cnt;
        }
    }
}
