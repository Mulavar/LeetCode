import java.util.HashMap;
import java.util.Map;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * @author Lam
 * @ClassName P887SuperEggDrop
 * @date 2020/9/26
 */
public class P887SuperEggDrop {
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * K个鸡蛋N层楼最小试探次数
     * 记忆化搜索+二分
     */
    public int superEggDrop(int K, int N) {
        if (map.containsKey(N * 100 + K)) {
            return map.get(N * 100 + K);
        }
        // 0层或1层
        if (N <= 1) {
            return N;
        }

        // 只有一个鸡蛋，则从1层开始扔
        if (K == 1) {
            return N;
        }

        int low = 1;
        int high = N;
        int ans = -1;
        while (low + 1 < high) {
            int x = low + (high - low) / 2;
            // 鸡蛋碎了
            int f1 = superEggDrop(K - 1, x - 1);
            // 鸡蛋没碎
            int f2 = superEggDrop(K, N - x);

            if (f1 < f2) {
                low = x;
            } else if (f1 > f2) {
                high = x;
            } else {
                low = high = x;
            }
        }

        // 在low和high两种决策中选择代价更小的
        ans = 1 + Math.min(Math.max(superEggDrop(K - 1, low - 1), superEggDrop(K, N - low)),
                Math.max(superEggDrop(K - 1, high - 1), superEggDrop(K, N - high)));
        map.put(N * 100 + K, ans);
        return map.get(N * 100 + K);
    }
}
