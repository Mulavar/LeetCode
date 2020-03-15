import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * @author Lam
 * @ClassName P697DegreeAnArray
 * @date 2020/2/28
 */
public class P697DegreeAnArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Node> map = new HashMap<>();
        int result = Integer.MAX_VALUE;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            Node node;
            if (map.containsKey(nums[i])) {
                node = map.get(nums[i]);
                node.count++;
                node.distance = i - node.begin + 1;
            } else {
                node = new Node(1, i, Integer.MAX_VALUE);
            }
            maxCount = Math.max(maxCount, node.count);
            map.put(nums[i], node);
        }

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if (entry.getValue().count == maxCount) {
                result = Math.min(result, entry.getValue().distance);
            }
        }

        if (result == Integer.MAX_VALUE) {
            return 1;
        } else {
            return result;
        }
    }

    class Node {
        int count;
        int begin;
        int distance;

        public Node(int count, int begin, int distance) {
            this.count = count;
            this.begin = begin;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(new P697DegreeAnArray().findShortestSubArray(nums));
    }
}
