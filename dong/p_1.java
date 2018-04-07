import java.util.HashMap;
import java.util.Map;

public class p_1 {

    public static void main(String[] args) {

        int[] nums = {3,5,4};

        Solution s = new Solution();

        int[] res = s.twoSum(nums, 9);

        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        int[] res = new int[2];
        for(int l = 0 ; l < nums.length ; l++){
            if(map.containsKey(nums[l])){
                res[0] = l;
                res[1] = map.get(nums[l]);
                return res;
            }
            map.put(target - nums[l],l);
        }
        return res;
    }
}