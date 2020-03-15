package week177;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Lam
 * @ClassName P4
 * @date 2020/2/23
 */
public class P4 {
    public String largestMultipleOfThree(int[] digits) {
        digits = IntStream.of(digits).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[][] nums = new int[3][digits.length];
        int cnt1 = 0;
        int cnt2 = 0;
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int digit : digits) {
            if (digit % 3 == 0) {
                list.add(digit);
            } else if (digit % 3 == 1) {
                nums[1][cnt1++] = digit;
                sum += digit;
            } else {
                nums[2][cnt2++] = digit;
                sum += digit;
            }
        }


        if (sum % 3 != 0) {
            if (list.size() == 0 && ((cnt1 == 0 && cnt2 < 3) || (cnt2 == 0 && cnt1 < 3))) {
                return "";
            }
            if (sum % 3 == 1) {
                if (cnt1 > 0) {
                    cnt1--;
                } else {
                    cnt2 -= 2;
                }
            } else {
                if (cnt2 > 0) {
                    cnt2--;
                } else {
                    cnt1 -= 2;
                }
            }
        }
        addNums(list, nums[1], cnt1);
        addNums(list, nums[2], cnt2);

        list.sort(Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        if (list.get(0) == 0) {
            return "0";
        }
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
        }
        return result.toString();
    }

    private void addNums(List<Integer> list, int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            list.add(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new P4().largestMultipleOfThree(nums));
    }
}
