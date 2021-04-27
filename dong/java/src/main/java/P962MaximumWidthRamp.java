import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中 i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 */
public class P962MaximumWidthRamp {
    /**
     * 单调栈
     */
    public int maxWidthRamp(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);

        for (int i = 1; i < A.length; i++) {
            int size = list.size();
            // todo 使用二分搜索可以更快
            if (A[list.get(size - 1)] > A[i]) {
                list.add(i);
                continue;
            }
            for (int j = size - 1; j >= 0; j--) {
                int idx = list.get(j);
                if (A[idx] <= A[i]) {
                    count = Math.max(count, i - idx);
                } else {
                    break;
                }
            }
        }

        return count;
    }

    /**
     * 将数组的下标 indexes(int[]) 根据数组值进行排序，
     * 则问题变成了在 max(indexes[j] - indexes[i]]) j > i
     */
    public int maxWidthRamp1(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i : B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }

}
