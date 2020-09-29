import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。
 * 当然，她横、竖、斜都可走一或七步，可进可退
 * Tips: 回溯
 *
 * @author Lam
 * @date 2020/5/11
 */
public class P51NQueens {
    public List<List<String>> solveNQueens(int n) {
        // note: 这里需要用int[][]而不是boolean[][]
        // 这是因为每个皇后会影响行、列、斜三个方向的格子，可能会出现多个皇后影响了同一个格子的情况
        // 使用boolean[][]的话会影响状态回退
        int[][] visitedBoxes = new int[n][n];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        // 对选取行做了优化
        List<List<String>> result = new ArrayList<>();
        char[][] curAns = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                curAns[i][j] = '.';
            }
        }

        // 按列填充放置
        for (int i = 0; i < n; i++) {
            // st标识放的行号
            int st = list.remove(i);
            curAns[st][0] = 'Q';

            // 给斜向打上标记
            for (int j = st, k = 0; j < n && k < n; j++, k++) {
                visitedBoxes[j][k]++;
            }
            for (int j = st - 1, k = 1; j >= 0 && k < n; j--, k++) {
                visitedBoxes[j][k]++;
            }

            backtrack(result, curAns, list, visitedBoxes, n, st, 1);

            // 回溯标记
            for (int j = st, k = 0; j < n && k < n; j++, k++) {
                visitedBoxes[j][k]--;
            }
            for (int j = st - 1, k = 1; j >= 0 && k < n; j--, k++) {
                visitedBoxes[j][k]--;
            }

            list.add(i, st);
            curAns[st][0] = '.';
        }
        return result;

    }

    private void backtrack(List<List<String>> result, char[][] curAns, List<Integer> remained, int[][] visitedBoxes, int n, int curRow, int curCol) {
        // 排到最后一列结束
        if (curCol == n) {
            // 记录结果
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tmp.add(new String(curAns[i]));
            }
            result.add(tmp);
            return;
        }

        for (int i = 0; i < remained.size(); i++) {
            // 标记当前行访问过
            int nextRow = remained.remove(i);
            curAns[nextRow][curCol] = 'Q';

            // 查看是否符合要求
            if (Math.abs(nextRow - curRow) > 1 && visitedBoxes[nextRow][curCol] == 0) {
                // 斜线标记为不可放置
                for (int j = nextRow, k = curCol; j < n && k < n; j++, k++) {
                    visitedBoxes[j][k]++;
                }
                for (int j = nextRow - 1, k = curCol + 1; j >= 0 && k < n; j--, k++) {
                    visitedBoxes[j][k]++;
                }

                backtrack(result, curAns, remained, visitedBoxes, n, nextRow, curCol + 1);

                // 回退状态
                for (int j = nextRow, k = curCol; j < n && k < n; j++, k++) {
                    visitedBoxes[j][k]--;
                }
                for (int j = nextRow - 1, k = curCol + 1; j >= 0 && k < n; j--, k++) {
                    visitedBoxes[j][k]--;
                }
            }

            // 回退状态
            curAns[nextRow][curCol] = '.';
            remained.add(i, nextRow);
        }
    }
}
