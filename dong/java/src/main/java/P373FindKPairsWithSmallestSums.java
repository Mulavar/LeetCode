import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * @author Lam
 * @ClassName P373FindKPairsWithSmallestSums
 * @date 2020/10/7
 */
public class P373FindKPairsWithSmallestSums {
    /**
     * 堆解法
     * 另外可使用多下标记录数组，参考P313
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length==0||nums2.length==0) {
            return result;
        }

        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new int[]{i, 0});
        }

        while (k > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            System.out.println("pairs:" + Arrays.toString(pair));
            result.add(new ArrayList<Integer>() {
                {
                    add(nums1[pair[0]]);
                    add(nums2[pair[1]]);
                }
            });

            if (pair[1] < nums2.length - 1) {
                queue.offer(new int[]{pair[0], pair[1] + 1});
            }

            k--;
        }

        return result;
    }
}
