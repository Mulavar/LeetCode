import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * @author Lam
 * @date 2020/5/23
 */
public class P239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (k == 1) {
            return nums;
        }
        //if k is more then n

        int[] result = new int[n - k + 1];
        int[] weight = new int[n];


        Deque<Integer> queue = new ArrayDeque<>();
        //初始化
        queue.add(0);
        for (int i = 1; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                int idx = queue.removeLast();
                weight[i] += weight[idx] + 1;
            }
            queue.add(i);
        }

        result[0] = nums[queue.peek()];
        for (int i = k; i < n; i++) {
            if (--weight[queue.peek()] < 0) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                int idx = queue.removeLast();
                weight[i] += weight[idx] + 1;
            }
            queue.add(i);
            result[i + 1 - k] = nums[queue.peek()];
        }

        return result;
    }

    /**
     * 同样使用双端队列，实际不需要weight
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;

        if (k == 1) {
            return nums;
        }

        int[] result = new int[n - k + 1];


        Deque<Integer> queue = new ArrayDeque<>();
        //初始化
        queue.add(0);
        for (int i = 1; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.add(i);
        }

        result[0] = nums[queue.peek()];
        for (int i = k; i < n; i++) {
            if (queue.peek() == i - k) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.add(i);
            result[i + 1 - k] = nums[queue.peek()];
        }

        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;

        if (k == 1) {
            return nums;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n - k + 1];

        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < n; i++) {
            leftMax = (i % k == 0) ? nums[i] : Math.max(leftMax, nums[i]);
            left[i] = leftMax;

            int j = n - 1 - i;
            rightMax = ((j + 1) % k == 0) ? nums[j] : Math.max(rightMax, nums[j]);
            right[j] = rightMax;
        }

        for (int i = 0; i < n + 1 - k; i++) {
            result[i] = Math.max(right[i], left[i + k-1]);
        }

        return result;
    }
}
