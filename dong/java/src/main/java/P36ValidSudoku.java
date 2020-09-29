import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * @author Lam
 * @ClassName P36ValidSudoku
 * @date 2020/1/14
 */
public class P36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 行set
        Set<Character> rowExisted = new HashSet<Character>();
        // 列set
        Set<Character> colExisted = new HashSet<Character>();

        for (int i = 0; i < 9; i++) {
            rowExisted.clear();
            colExisted.clear();
            for (int j = 0; j < 9; j++) {
                // 判断第i行是否有重复元素
                if (board[i][j] != '.') {
                    if (rowExisted.contains(board[i][j])) {
                        return false;
                    } else {
                        rowExisted.add(board[i][j]);
                    }
                }

                // 判断第i列是否有重复元素
                if (board[j][i] != '.') {
                    if (colExisted.contains(board[j][i])) {
                        return false;
                    } else {
                        colExisted.add(board[j][i]);
                    }
                }
            }
        }

        rowExisted.clear();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                // 使用rowExisted去判断每个3x3宫格是否有重复
                rowExisted.clear();
                for (int k1 = i; k1 < i + 3; k1++) {
                    for (int k2 = j; k2 < j + 3; k2++) {
                        if (board[k1][k2] != '.') {
                            if (rowExisted.contains(board[k1][k2])) {
                                return false;
                            } else {
                                rowExisted.add(board[k1][k2]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
