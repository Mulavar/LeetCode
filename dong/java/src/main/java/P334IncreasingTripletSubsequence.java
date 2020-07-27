import java.util.Stack;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * @author Lam
 * @date 2020/7/24
 */
public class P334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // 考虑相等的情况
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * 单调栈做法
     */
    public boolean increasingTriplet1(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < nums.length) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            stack.push(i++);
            if (stack.size() >= 3) {
                return true;
            }
        }

        stack.clear();
        i = nums.length - 1;
        while (i >= 0) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            stack.push(i--);
            if (stack.size() >= 3) {
                return true;
            }
        }

        return false;
    }
}
