import java.util.ArrayList;
import java.util.List;

/**
 * 给定 n 和 k，返回第 k 个排列。
 *
 * @author Lam
 * @ClassName P60PermutationSequence
 * @date 2020/9/29
 */
public class P60PermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int divisor = 1;
        for (int i = 0; i < n; i++) {
            divisor *= (i + 1);
            list.add(i + 1);
        }

        StringBuilder result = new StringBuilder();
        while (!list.isEmpty()) {
            divisor /= list.size();
            int idx = (k - 1) / divisor;
            k -= idx * divisor;
            result.append(list.get(idx));
            list.remove(idx);
        }
        return result.toString();
    }

    private int count = 0;

    /**
     * 该解法有问题，因为在交换的时候无法保证保留最小序状态，
     * 如 1 2 3，当1和3交换时直接得到 3 2 1，跳过了3 1 2
     */
    @Deprecated
    private String backtrack(int[] nums, int index, int k) {
        if (count == k) {
            return arrToString(nums);
        }

        if (index == nums.length) {
            count++;
            return arrToString(nums);
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            backtrack(nums, index + 1, k);
            if (count >= k) {
                break;
            }
            swap(nums, index, i);
        }

        return arrToString(nums);
    }

    private String arrToString(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
