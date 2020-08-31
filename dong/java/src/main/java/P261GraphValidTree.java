/**
 * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），
 * 请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
 *
 * @author Lam
 * @date 2020/8/30
 */
public class P261GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length==0) {
            if (n==1) {
                return true;
            }
            return false;
        }
        // 本质是判断该图是否有环

        int[] visited = new int[n];
        int[][] graph = new int[n][n];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u][v] = graph[v][u] = 1;
        }

        if (!dfs(edges[0][0], visited, graph)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int u, int[] visited, int[][] graph) {
        // 1 表示遍历过当前节点，还没完成对该节点的dfs遍历
        visited[u] = 1;

        for (int i = 0; i < graph.length; i++) {
            // 无向图特殊处理
            if (graph[u][i] == 1) {
                // 避免无向图在一条边上重复来回遍历
                // 也可以通过父节点做
                graph[i][u] = 0;

                if (visited[i] == 1 || !dfs(i, visited, graph)) {
                    return false;
                }

            }
        }

        visited[u] = 2;
        return true;
    }

}
