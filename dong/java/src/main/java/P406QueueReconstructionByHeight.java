import java.util.Arrays;
import java.util.Comparator;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * 注意：
 * 总人数少于1100人。
 *
 * @author Lam
 * @date 2020/6/3
 */
public class P406QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });

        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            if (i == 0) {
                result[i] = people[i];
                continue;
            }
            //insert sort
            for (int j = i; j > people[i][1]; j--) {
                result[j] = result[j - 1];
            }
            result[people[i][1]] = people[i];
        }

        return result;
    }

}
