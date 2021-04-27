import java.util.HashMap;
import java.util.Map;

public class P525ContiguousArray {
    public int findMaxLength(int[] nums) {
        int oneCount = 0;
        int maxCount = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            oneCount += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(oneCount)) {
                maxCount = Math.max(maxCount, i - map.get(oneCount));
            } else {
                map.put(oneCount, i);
            }
        }

        return maxCount;
    }
}
