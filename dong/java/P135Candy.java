/**
 * @author Lam
 * @ClassName P135Candy
 * @date 2020/2/19
 */
public class P135Candy {
    // 暴力破解
    class Solution {
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
    }

    // 优化方案：从左到右遍历一次，从右到左再遍历一次
    class Solution1 {
        public int candy(int[] ratings) {
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
    }

    public static void main(String[] args) {
        int[] grades = new int[]{29, 51, 87, 87, 72, 12};
        System.out.println(new P135Candy().new Solution().candy(grades));
        System.out.println(new P135Candy().new Solution1().candy(grades));
    }
}
