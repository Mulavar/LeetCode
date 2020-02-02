/**
 * @author Lam
 * @ClassName P223RectangleArea
 * @date 2020/2/2
 */
public class P223RectangleArea {
    class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int result;
            result = (D - B) * (C - A) + (H - F) * (G - E);
            if (E >= C || F >= D || G <= A || H <= B) {
                // 无重叠面积
                return result;
            } else {
                int leftX = Math.max(A, E);
                int leftY = Math.max(B, F);
                int rightX = Math.min(C, G);
                int rightY = Math.min(D, H);
                result -= (rightX - leftX) * (rightY - leftY);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P223RectangleArea().new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
