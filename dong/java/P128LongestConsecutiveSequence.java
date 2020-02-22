import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * @author Lam
 * @ClassName P128LongestConsecutiveSequence
 * @date 2020/2/22
 */
public class P128LongestConsecutiveSequence {
    // 本题还可以使用并查集，对每个num 联合num-1和num+1

    class Solution {
        /**
         * 使用优先队列排序，时间复杂度O(nlogn)
         */
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for (int num : nums) {
                queue.offer(num);
            }

            int result = 0;
            int pre = queue.poll();
            int cur;
            int curCount = 1;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                if (cur == pre + 1) {
                    pre = cur;
                    curCount++;
                } else if (cur == pre) {
                    continue;
                } else {
                    result = Math.max(result, curCount);
                    pre = cur;
                    curCount = 1;
                }
            }

            result = Math.max(result, curCount);
            return result;
        }
    }

    class Solution1 {
        /**
         * 使用hashset
         */
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int result = 0;
            for (int num : nums) {
                if (!set.contains(num - 1)) {
                    int count = 1;
                    int i = 1;
                    while (set.contains(num + i)) {
                        i++;
                        count++;
                    }
                    result = Math.max(result, count);
                }
            }

            return result;
        }
    }
}
