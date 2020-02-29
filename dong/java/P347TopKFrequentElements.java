import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @author Lam
 * @ClassName P347TopKFrequentElements
 * @date 2020/2/29
 */
public class P347TopKFrequentElements {
    /**
     * 先使用map，再使用桶排序的思想，将频度作为数组下标，最后逆序遍历。
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] cnts = new ArrayList[nums.length + 1];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (cnts[value] == null) {
                cnts[value] = new ArrayList<>();
            }
            cnts[value].add(entry.getKey());
        }

        for (int i = nums.length; i >= 0; i--) {
            if (k <= 0) {
                break;
            }

            if (cnts[i] != null) {
                result.addAll(cnts[i]);
                k -= cnts[i].size();
            }
        }

        while (k < 0) {
            result.remove(result.size() - 1);
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new P347TopKFrequentElements().topKFrequent(nums, 1));
    }
}

