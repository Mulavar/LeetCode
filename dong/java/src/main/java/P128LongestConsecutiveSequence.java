import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    /**
     * 使用hashset
     */
    public int longestConsecutive1(int[] nums) {
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

    /**
     * 本题还可以使用并查集思想，对每个num 联合num和num+1
     */
    public int longestConsecutive2(int[] nums) {
        initUnion(nums);

        for (int num :
                nums) {
            // 合并num和num+1
            // 根据并查集实现，假如num+1不存在，则不会真的执行合并
            union(num, num + 1);
        }
        
        int result = 0;

        for (int num :
                nums) {
            // 计算最大距离
            result = Math.max(find(num) - num + 1, result);
        }

        return result;
    }


    /**
     * ***********************
     * 并查集实现（基于map）
     * ***********************
     */
    Map<Integer, Integer> parent = new HashMap<>();

    private void initUnion(int[] nums) {
        for (int num :
                nums) {
            parent.put(num, num);
        }
    }

    private int find(int num) {
        int p = num;
        while (parent.containsKey(p) && parent.get(p) != p) {
            p = parent.get(p);
        }

        // 不存在该值，则直接返回
        if (!parent.containsKey(p)) {
            return Integer.MIN_VALUE;
        }

        while (parent.get(num) != num) {
            int tmp = parent.get(num);
            parent.put(num, p);
            num = tmp;
        }

        return p;
    }

    private void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        // 如果两个值是同一个集合或某个值不存在，则返回
        if (n1 == n2 || p1 == Integer.MIN_VALUE || p2 == Integer.MIN_VALUE) {
            return;
        }

        // 合并
        parent.put(p1, p2);
    }

}
