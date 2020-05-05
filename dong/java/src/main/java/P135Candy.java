import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * @author Lam
 * @ClassName P135Candy
 * @date 2020/2/19
 */
public class P135Candy {
    // 暴力破解
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int result = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                candies[i] = 1;
            } else if (ratings[i] < ratings[i - 1]) {
                candies[i] = 1;
                int j = i;
                while (j > 0 && candies[j] == candies[j - 1] && ratings[j] < ratings[j - 1]) {
                    candies[j - 1]++;
                    j--;
                }
            } else if (ratings[i] == ratings[i - 1]) {
                candies[i] = 1;
            } else {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            result += candies[i];
        }

        return result;
    }


    // 贪心思想：从左到右遍历一次，从右到左再遍历一次
    public int candy1(int[] ratings) {
        int len = ratings.length;
        int result = 0;
        int[] candies = new int[len];
        for (int i = 0; i < len; i++) {
            candies[i] = i > 0 ? (ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : 1) : 1;
        }

        for (int i = len - 1; i >= 0; i--) {
            int candy = i < len - 1 ? (ratings[i] > ratings[i + 1] ? candies[i + 1] + 1 : 1) : 1;
            candies[i] = Math.max(candy, candies[i]);
            result += candies[i];
        }

        return result;
    }

    // 记忆化搜索：如果当前位置孩子得分比相邻的高，则先计算相邻孩子的得分
    public int candy2(int[] ratings) {
        int n = ratings.length;
        if (n < 2) {
            return n;
        }
        int[] candies = new int[n];
        Arrays.fill(candies, -1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += candies[i] == -1 ? solve(ratings, candies, i) : candies[i];
        }
        System.out.println(Arrays.toString(candies));
        return result;
    }

    private int solve(int[] ratings, int[] candies, int i) {
        if (candies[i] != -1) {
            return candies[i];
        }

        if (i == 0) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = solve(ratings, candies, i + 1) + 1;
            } else {
                candies[i] = 1;
            }
            return candies[i];
        } else if (i == ratings.length - 1) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = solve(ratings, candies, i - 1) + 1;
            } else {
                candies[i] = 1;
            }
            return candies[i];
        }

        int lc = 1;
        int rc = 1;
        if (ratings[i] > ratings[i - 1]) {
            lc = solve(ratings, candies, i - 1) + 1;

        }

        if (ratings[i] > ratings[i + 1]) {
            rc = solve(ratings, candies, i + 1) + 1;
        }

        candies[i] = Math.max(lc, rc);
        return candies[i];
    }

}
