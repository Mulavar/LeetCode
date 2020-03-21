import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Lam
 * @ClassName P218TheSkylineProblem
 * @date 2020/2/29
 */
public class P218TheSkylineProblem {
    /**
     * 扫描线法
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> lines = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        for (int[] building : buildings) {
            int[] left = new int[2];
            left[0] = building[0];
            left[1] = -building[2];
            int[] right = new int[2];
            right[0] = building[1];
            right[1] = building[2];
            lines.add(left);
            lines.add(right);
        }

        // 记录未处理完的矩形最大高度（每个拐点的y坐标值应该是当前所有未处理完的矩形里最大的）
        PriorityQueue<Integer> height = new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        while (!lines.isEmpty()){
            int[] line = lines.poll();
            int lastMaxHeight = height.isEmpty() ? 0 : height.peek();
            if (line[1] < 0) {
                height.offer(-line[1]);
            } else {
                height.remove(line[1]);
            }

            int curMaxHeight = height.isEmpty() ? 0 : height.peek();
            if (curMaxHeight != lastMaxHeight) {
                // 如果是左线，即curMaxHeight>lastMaxHeight
                // 如果是右线，即curMaxHeight<lastMaxHeight
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(line[0]);
                tmp.add(curMaxHeight);
                result.add(tmp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(new P218TheSkylineProblem().getSkyline(nums));

    }
}
