package week198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lam
 * @date 2020/7/19
 */
public class P2 {
    /**
     * 计数，用来传递父子结点之间的字母映射
     */
    int[][] cnt = new int[100005][26];
    /**
     * 记录结果
     */
    int[] result;

    /**
     * 标签字符串
     */
    String string;

    /**
     * 必须使用邻接表，不然内存超限
     */
    List<Integer>[] graphs;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.graphs = new ArrayList[n];
        this.result = new int[n];
        this.string = labels;

        for (int i = 0; i < n; i++) {
            graphs[i] = new ArrayList<>();
        }

        // 构建图
        for (int i = 0; i < edges.length; i++) {
            graphs[edges[i][1]].add(edges[i][0]);
            graphs[edges[i][0]].add(edges[i][1]);
        }

        dfs(0, -1);

        return result;
    }

    /**
     * 记录父结点避免重复访问，
     * 使用该标记而不是用visited数组可以节省空间
     */
    private void dfs(int idx, int father) {
        char ch = string.charAt(idx);
        for (int i = 0; i < graphs[idx].size(); i++) {
            // 下一个要遍历的结点
            Integer v = graphs[idx].get(i);
            if (v != father) {
                dfs(v, idx);

                for (int j = 0; j < 26; j++) {
                    cnt[idx][j] += cnt[v][j];
                }


            }
        }

        cnt[idx][ch - 'a']++;
        result[idx] = cnt[idx][ch - 'a'];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P2().countSubTrees(4, new int[][]{{0, 1}, {1, 2}, {0, 3}}, "bbbb")));
    }
}
