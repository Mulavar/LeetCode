import java.util.ArrayList;
import java.util.List;

/**
 * @author Lam
 * @date 2019/12/3
 */
public class P17LetterCombinations {
    class Solution {
        public List<String> letterCombinations(String digits) {
            char[][] mapping = new char[10][4];
            mapping[2] = new char[]{'a', 'b', 'c', ' '};
            mapping[3] = new char[]{'d', 'e', 'f', ' '};
            mapping[4] = new char[]{'g', 'h', 'i', ' '};
            mapping[5] = new char[]{'j', 'k', 'l', ' '};
            mapping[6] = new char[]{'m', 'n', 'o', ' '};
            mapping[7] = new char[]{'p', 'q', 'r', 's'};
            mapping[8] = new char[]{'t', 'u', 'v', ' '};
            mapping[9] = new char[]{'w', 'x', 'y', 'z'};

            List<String> result = new ArrayList<>();
            StringBuilder letters = new StringBuilder();
            if (digits.length() != 0) {
                dfs(result, mapping, digits, letters);
            }
            return result;
        }

        public void dfs(List<String> result, char[][] mapping, String digits, StringBuilder letters) {
            if (letters.length() == digits.length()) {
                result.add(letters.toString());
                letters.setLength(letters.length() - 1);
                return;
            }

            int idx = letters.length();
            int digit = digits.charAt(idx) - '0';
            for (int i = 0; i < 4; i++) {
                if (mapping[digit][i] != ' ') {
                    dfs(result, mapping, digits, letters.append(mapping[digit][i]));
                }
            }
            if (letters.length() != 0) {
                letters.setLength(letters.length() - 1);
            }

        }
    }

}
