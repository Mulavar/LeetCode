import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Lam
 * @ClassName P310MinimumHeightTrees
 * @date 2020/2/27
 */
public class P310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        for (int i = 0; i < edges.length; i++) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        // 建立邻接表
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            lists.get(node1).add(node2);
            lists.get(node2).add(node1);
        }

        //找到度为1的节点们
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            result = new ArrayList<>();
            int size = queue.size();

            while (size != 0) {
                int node = queue.poll();
                result.add(node);
                for (int nextNode : lists.get(node)) {
                    degree[nextNode]--;
                    if (degree[nextNode] == 1) {
                        queue.offer(nextNode);
                    }
                }
                size--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 0}, {1, 2}, {1, 3},
        };
        int n = 4;
        new P310MinimumHeightTrees().findMinHeightTrees(n, edges);
    }
}
