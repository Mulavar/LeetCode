package week178;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Lam
 * @ClassName P2
 * @date 2020/3/1
 */
public class P2 {
    public String rankTeams(String[] votes) {
        int[][] rank = new int[30][30];
        for (int i = 0; i < votes.length; i++) {
            String vote = votes[i];
            for (int j = 0; j < vote.length(); j++) {
                char ch = vote.charAt(j);
                rank[ch - 'A'][0] = ch - 'A' + 1;
                rank[ch - 'A'][j + 1]++;
            }
        }

        System.out.println(Arrays.deepToString(rank));
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 1; i < o1.length; i++) {
                    if (o1[i] != o2[i]) {
                        return o2[i] - o1[i];
                    }
                }
                return o1[0] - o2[0];
            }
        });

        for (int[] r : rank) {
            if (r[0] != 0) {
                queue.offer(r);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            result.append((char)(queue.poll()[0] + 'A' - 1));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] votes = new String[]{"WXYZ","XYZW"};
        System.out.println(new P2().rankTeams(votes));
    }
}
