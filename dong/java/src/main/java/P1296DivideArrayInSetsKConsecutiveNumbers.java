import java.util.TreeMap;

public class P1296DivideArrayInSetsKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }

        for (int key : map.keySet()) {
            while (map.get(key) != 0) {
                for (int i = 0; i < k; i++) {
                    int count = map.getOrDefault(key + i, 0);
                    if (count < 1) {
                        return false;
                    }
                    map.put(key + i, count - 1);
                }
            }
        }

        return true;
    }
}
