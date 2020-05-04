import java.util.Arrays;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * @author Lam
 * @ClassName P37SudokuSolver
 * @date 2020/2/6
 */
public class P37SudokuSolver {
    /**
     * 思路：
     * 填充顺序可以按行、列、方格来，这里选择按行
     */
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row > 8) {
            return true;
        }

        boolean solved = false;
        if (board[row][col] == '.') {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (!checkValid(board, row, col, ch)) {
                    continue;
                }
                board[row][col] = ch;
                if (col == 8) {
                    solved = solve(board, row + 1, 0);
                } else {
                    solved = solve(board, row, col + 1);
                }
                if (!solved) {
                    board[row][col] = '.';
                } else {
                    break;
                }
            }
        } else {
            if (col == 8) {
                solved = solve(board, row + 1, 0);
            } else {
                solved = solve(board, row, col + 1);
            }
        }

        return solved;
    }

    private boolean checkValid(char[][] board, int row, int col, char ch) {
        // check row and col
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch || board[i][col] == ch) {
                return false;
            }
        }

        // check box
        for (int i = row / 3 * 3; i < (row / 3 + 1) * 3; i++) {
            for (int j = col / 3 * 3; j < (col / 3 + 1) * 3; j++) {
                if (board[i][j] == ch) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 用空间换时间，使用三个数组记录某个值是否合法
     */
    public void solveSudoku1(char[][] board) {
        // boxes：记录每个box里已有的值
        boolean[][] boxes = new boolean[9][9];
        // visitedRow：记录每行已有的值
        boolean[][] visitedRow = new boolean[9][9];
        // visitedCol：记录每列已有的值
        boolean[][] visitedCol = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int id = (i / 3) * 3 + j / 3;
                boxes[id][num] = true;
                visitedRow[i][num] = true;
                visitedCol[num][j] = true;
            }
        }

        if (!update(0, board, boxes, visitedRow, visitedCol)){
            throw new IllegalArgumentException();
        }
    }

    private boolean update(int pos, char[][] board, boolean[][] sections,
                           boolean[][] visitedRow, boolean[][] visitedCol) {
        if (pos > 80) {
            return true;
        }

        // 根据pos计算需要填的位置row和col
        int row = pos / 9, col = pos % 9, id = (row / 3) * 3 + col / 3;
        if (board[row][col] != '.') {
            return update(pos + 1, board, sections, visitedRow, visitedCol);
        }

        for (int i = 0; i < 9; i++) {
            if (sections[id][i] || visitedRow[row][i] ||
                    visitedCol[i][col]) {
                continue;
            }

            sections[id][i] = true;
            visitedRow[row][i] = true;
            visitedCol[i][col] = true;

            board[row][col] = (char) (i + '1');
            if (update(pos + 1, board, sections, visitedRow, visitedCol)) {
                return true;
            }

            board[row][col] = '.';
            sections[id][i] = false;
            visitedRow[row][i] = false;
            visitedCol[i][col] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };

        new P37SudokuSolver().solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
