import java.util.Arrays;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。
 * 他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，
 * 那么我们可以认为 A 也是 C 的朋友。
 * 所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
 * 否则为不知道。你必须输出所有学生中的已知的朋友圈总数
 *
 * @author Lam
 * @ClassName P547FriendCircles
 * @date 2020/3/11
 */
public class P547FriendCircles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] friends = new int[n];
        Arrays.fill(friends, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j && M[i][j] == 1) {
                    union(friends, i, j);
                }
            }
            System.out.println(Arrays.toString(friends));
        }

        System.out.println(Arrays.toString(friends));
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (friends[i] == -1) {
                result++;
            }
        }
        return result;
    }

    private void union(int[] friends, int i, int j) {
        int root1 = find(friends, i);
        int root2 = find(friends, j);
        if (root1!=root2) {
            friends[root1] = root2;
        }
    }

    private int find(int[] friends, int i) {
        if (friends[i] == -1) {
            return i;
        } else {
            friends[i] = find(friends, friends[i]);
        }
        return friends[i];
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };
        new P547FriendCircles().findCircleNum(M);
    }
}
