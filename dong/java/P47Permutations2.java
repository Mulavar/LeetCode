import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Lam
 * @ClassName P47Permutations2
 * @date 2020/1/25
 */
public class P47Permutations2 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();
            backtrace(nums, 0, result);
            return new ArrayList<>(result);
        }

        //note：Set的判重根据对象的hashcode的equals方法来判断，由于AbstractList重写了equals方法，
        //当两个集合内的元素完全相同且顺序一致，则两个ArrayList就相等。
        public void backtrace(int[] nums, int idx, Set<List<Integer>> result) {
            if (idx == nums.length) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int num :
                        nums) {
                    tmp.add(num);
                }
                result.add(tmp);
            }

            for (int i = idx; i < nums.length; i++) {
                swap(nums, idx, i);
                backtrace(nums, idx + 1, result);
                swap(nums, idx, i);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    class Solution1 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrace(nums, 0, result);
            return result;
        }

        public void backtrace(int[] nums, int idx, List<List<Integer>> result) {
            if (idx == nums.length) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int num :
                        nums) {
                    tmp.add(num);
                }
                result.add(tmp);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = idx; i < nums.length; i++) {
                if (i == idx || (nums[i] != nums[idx] && set.add(nums[i]))) {
                    swap(nums, idx, i);
                    backtrace(nums, idx + 1, result);
                    swap(nums, idx, i);
                }
            }
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        ArrayList<Object> list1 = new ArrayList<>();
        list.add(1);
        list1.add(1);
        System.out.println(list.equals(list1));
    }
}
