/**
 * @author Lam
 * @ClassName P134GasStation
 * @date 2020/2/19
 */
public class P134GasStation {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int gasSum = 0;
            int costSum = 0;
            for (int i = 0; i < gas.length; i++) {
                gasSum += gas[i];
                costSum += cost[i];
            }
            if (gasSum < costSum) {
                return -1;
            }

            int gasRemained = 0;
            int left = 0;
            int len = gas.length;
            int res = 0;
            while (left < len) {
                gasRemained += gas[left] - cost[left];
                left++;
                if (gasRemained < 0) {
                    res = left;
                    gasRemained = 0;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(new P134GasStation().new Solution().canCompleteCircuit(gas, cost));
    }
}
