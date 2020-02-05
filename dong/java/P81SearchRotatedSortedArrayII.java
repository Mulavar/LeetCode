/**
 * @author Lam
 * @ClassName P81SearchRotatedSortedArrayII
 * @date 2020/2/5
 */
public class P81SearchRotatedSortedArrayII {
    class Solution {
        public boolean search(int[] nums, int target) {
//            int left = 0;
//            int right = nums.length - 1;
//            if (nums.length == 0) {
//                return false;
//            }
//            while (left < right) {
//                int mid = (left + right) / 2;
//                System.out.println("l:" + left + ", mid:" + mid + ", r:" + right);
//                if (nums[mid] == target || nums[left] == target || nums[right] == target) {
//                    return true;
//                }
//                if (nums[mid] >= nums[left]) {
//                    if (nums[mid] < target) {
//                        left = mid + 1;
//                    } else {
//                        if (nums[left] < target) {
//                            right = mid - 1;
//                        } else {
//                            left = mid + 1;
//                        }
//                    }
//                } else {
//                    if (nums[mid] > target) {
//                        right = mid - 1;
//                    } else {
//                        if (nums[right] > target) {
//                            left = mid + 1;
//                        } else {
//                            right = mid - 1;
//                        }
//                    }
//                }
//            }
//            return nums[right] == target;
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        private boolean binarySearch(int[] nums, int start, int end, int target) {
            if (end < start) {
                return false;
            }
            int mid = (start + end) / 2;

            if (nums[start] == target || nums[mid] == target || nums[end] == target) {
                return true;
            }

            return binarySearch(nums, mid + 1, end, target) || binarySearch(nums, start, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        for (int i = 0; i < 7; i++) {
            System.out.println(new P81SearchRotatedSortedArrayII().new Solution().search(nums, i));
        }
    }
}
