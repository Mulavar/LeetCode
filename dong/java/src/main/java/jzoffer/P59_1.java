package jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * @author Lam
 * @date 2020/6/29
 */
public class P59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int idx = 0;
        int n = nums.length;
        if (n==0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1];
        int cnt = 0;

        while (idx < k) {
            while (!deque.isEmpty() && nums[deque.peekFirst()] <= nums[idx]) {
                deque.removeFirst();
            }
            deque.addFirst(idx++);
        }
        result[cnt++] = nums[deque.peekLast()];


        while (idx < n) {
            if (idx - deque.peekLast() >= k) {
                deque.removeLast();
            }

            while (!deque.isEmpty() && nums[deque.peekFirst()] <= nums[idx]) {
                deque.removeFirst();
            }

            deque.addFirst(idx);
            result[cnt++] = nums[deque.peekLast()];

            idx++;
        }

        return result;
    }
}
