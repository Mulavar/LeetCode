import java.util.HashSet;
import java.util.Set;

/**
 * @author Lam
 * @ClassName P36ValidSudoku
 * @date 2020/1/14
 */
public class P36ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            Set<Character> rowExisted = new HashSet<Character>();
            Set<Character> colExisted = new HashSet<Character>();
            for (int i = 0; i < 9; i++) {
                rowExisted.clear();
                colExisted.clear();
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        if (rowExisted.contains(board[i][j])) {
                            return false;
                        } else {
                            rowExisted.add(board[i][j]);
                        }
                    }
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
}
