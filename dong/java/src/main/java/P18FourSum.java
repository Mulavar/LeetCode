import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lam
 * @date
 */
public class P18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                int newTarget = target - (nums[i] + nums[j]);
                while (left < right) {
                    if (nums[left] + nums[right] == newTarget) {
                        System.out.println("i: " + i + ", j: " + j + ", left: " + left + ", right: " + right);
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (nums[left] + nums[right] < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }

        return result;
    }
}
