import bean.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lam
 * @ClassName TestP1RangeP100
 * @date 2020/3/15
 */
public class TestP1RangeP100 {
    private ListNode head;
    private ListNode head1;
    private int[][] matrix2;

    @Before
    public void prepare() {
        head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        matrix2 = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

        head1 = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(3);
        node4 = new ListNode(4);
        node5 = new ListNode(5);
        head1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = new ListNode(2);
    }

    @Test
    public void testP4MedianTwoSortedArrays() {
        P4MedianTwoSortedArrays solution1 = new P4MedianTwoSortedArrays();
        int[] nums1 = new int[]{1, 4, 5, 6};
        int[] nums2 = new int[]{2, 3};
        Assert.assertEquals(solution1.findMedianSortedArrays(nums1, nums2), solution1.findMedianSortedArrays2(nums1, nums2), 1e-4);
        nums1 = new int[]{1, 3, 4, 5};
        nums2 = new int[]{2};
        Assert.assertEquals(solution1.findMedianSortedArrays(nums1, nums2), solution1.findMedianSortedArrays2(nums1, nums2), 1e-4);
        nums1 = new int[]{1, 2, 4, 5};
        nums2 = new int[]{3};
        Assert.assertEquals(solution1.findMedianSortedArrays(nums1, nums2), solution1.findMedianSortedArrays2(nums1, nums2), 1e-4);
        nums1 = new int[]{1, 2, 4, 5, 6};
        nums2 = new int[]{7};
        Assert.assertEquals(solution1.findMedianSortedArrays(nums1, nums2), solution1.findMedianSortedArrays2(nums1, nums2), 1e-4);
        nums1 = new int[]{1, 2, 5, 6, 7};
        nums2 = new int[]{4};
        Assert.assertEquals(solution1.findMedianSortedArrays(nums1, nums2), solution1.findMedianSortedArrays2(nums1, nums2), 1e-4);

        nums1 = new int[]{1, 2, 4, 5, 7, 8};
        nums2 = new int[]{3, 6};
        Assert.assertEquals(solution1.findMedianSortedArrays(nums1, nums2), solution1.findMedianSortedArrays2(nums1, nums2), 1e-4);
    }

    @Test
    public void testP23MergeKSortedLists() {
        System.out.println(new P23MergeKSortedLists().mergeKLists(new ListNode[]{head, head1}));
    }

    @Test
    public void testP24SwapNodesInPairs() {
        System.out.println(new P24SwapNodesInPairs().swapPairs(head));
    }

    @Test
    public void testP25ReverseNodesInKGroup() {
        System.out.println(new P25ReverseNodesInKGroup().reverseKGroup(head, 2));
        prepare();
        System.out.println(new P25ReverseNodesInKGroup().reverseKGroup(head, 3));
    }

    @Test
    public void testP31NextPermutation() {
        int[] nums = new int[]{1, 2, 1, 3};
        new P31NextPermutation().nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 1}, nums);

        nums = new int[]{2, 5, 4, 3, 1};
        new P31NextPermutation().nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{3, 1, 2, 4, 5}, nums);
    }

    @Test
    public void testP32LongestValidParentheses() {
        String s = "()(())";
        Assert.assertEquals(6, new P32LongestValidParentheses().longestValidParentheses(s));
        s = "(()";
        Assert.assertEquals(2, new P32LongestValidParentheses().longestValidParentheses(s));
        s = ")()";
        Assert.assertEquals(2, new P32LongestValidParentheses().longestValidParentheses(s));
        s = ")()())";
        Assert.assertEquals(4, new P32LongestValidParentheses().longestValidParentheses(s));
        s = ")(";
        Assert.assertEquals(0, new P32LongestValidParentheses().longestValidParentheses(s));
        s = "())";
        Assert.assertEquals(2, new P32LongestValidParentheses().longestValidParentheses(s));
        s = "(()())";
        Assert.assertEquals(6, new P32LongestValidParentheses().longestValidParentheses(s));
    }

    @Test
    public void testP37SudokuSolver() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };

        new P37SudokuSolver().solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    @Test
    public void testP39CombinationSum() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(new P39CombinationSum().new Solution().combinationSum(candidates, target));
    }

    @Test
    public void testP42RrappingRainWater() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Assert.assertEquals(6, new P42RrappingRainWater().trap(height));
    }

    @Test
    public void testP51NQueens() {
        System.out.println(new P51NQueens().solveNQueens(4));
    }

    @Test
    public void testP51NQueensII() {
        Assert.assertEquals(2, new P52NQueensII().totalNQueens(4));
        Assert.assertEquals(4, new P52NQueensII().totalNQueens(6));
    }

    @Test
    public void testP54SpiralMatrix() {
        System.out.println(new P54SpiralMatrix().spiralOrder(matrix2));
        prepare();
        ArrayList<Integer> result = new ArrayList<>();
        new P54SpiralMatrix().recursiveSpiral(result, matrix2, 0, 0, 4, 4);
        System.out.println(result);
    }

    @Test
    public void testP56MergeIntervals() {
        int[][] datas = new int[][]{
                {2, 6},
                {1, 3},
                {15, 18},
                {8, 10},
        };

        int[][] merge = new P56MergeIntervals().merge(datas);
        System.out.println(Arrays.deepToString(merge));
    }

    @Test
    public void testP57InsertIntervals() {
        int[][] datas = new int[][]{
                {1, 2},
                {3, 6},
                {8, 10},
                {15, 18},
        };

        int[][] merge = new P57InsertIntervals().insert(datas, new int[]{2, 5});
        System.out.println(Arrays.deepToString(merge));

        int[][] datas1 = new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16},
        };
        int[][] merge1 = new P57InsertIntervals().insert1(datas1, new int[]{4, 8});
        System.out.println(Arrays.deepToString(merge1));
    }

    @Test
    public void testP59SpiralMatrixII() {
        System.out.println(Arrays.deepToString(new P59SpiralMatrixII().generateMatrix(5)));
    }

    @Test
    public void testP60PermutationSequence() {
        Assert.assertEquals("132", new P60PermutationSequence().getPermutation(3, 2));
        Assert.assertEquals("213", new P60PermutationSequence().getPermutation(3, 3));
        Assert.assertEquals("2314", new P60PermutationSequence().getPermutation(4, 9));
        Assert.assertEquals("321", new P60PermutationSequence().getPermutation(3, 6));
        Assert.assertEquals("312", new P60PermutationSequence().getPermutation(3, 5));
    }

    @Test
    public void testP82RemoveDuplicatesFromSortedListII() {
        System.out.println(new P82RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
    }

    @Test
    public void testP61RotateList() {
        System.out.println(new P61RotateList().rotateRight(head, 10));
    }

    @Test
    public void testP72EditDistance() {
        Assert.assertEquals(3, new P72EditDistance().minDistance("horse", "ros"));
        Assert.assertEquals(3, new P72EditDistance().minDistance1("horse", "ros"));
    }

    @Test
    public void testP74Search2dMatrix() {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        Assert.assertTrue(new P74Search2dMatrix().searchMatrix(matrix, 3));
        Assert.assertFalse(new P74Search2dMatrix().searchMatrix(matrix, 13));
    }

    @Test
    public void testP77Combinations() {
        System.out.println(new P77Combinations().combine(5, 3));
    }

    @Test
    public void testP83RemoveDuplicatesFromSortedList() {
        System.out.println(new P83RemoveDuplicatesFromSortedList().deleteDuplicates(head));
    }

    @Test
    public void testP84LargestRectangleHistogram() {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        Assert.assertEquals(new P84LargestRectangleHistogram().largestRectangleArea(heights), new P84LargestRectangleHistogram().largestRectangleArea2(heights));
    }

    @Test
    public void testP85MaximalRectangle() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        Assert.assertEquals(6, new P85MaximalRectangle().maximalRectangle(matrix));

        char[][] matrix1 = new char[][]{
                {'1', '0', '1', '0'},
                {'1', '0', '1', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '1', '1'},
        };
        Assert.assertEquals(6, new P85MaximalRectangle().maximalRectangle1(matrix1));

        char[][] matrix2 = new char[][]{
                {'0', '1'},
                {'1', '0'},
        };
        Assert.assertEquals(1, new P85MaximalRectangle().maximalRectangle1(matrix2));
    }

    @Test
    public void testP86PartitionList() {
        System.out.println(new P86PartitionList().partition(head1, 3));
    }

    @Test
    public void testP92ReverseLinkedListII() {
        System.out.println(new P92ReverseLinkedListII().reverseBetween(head, 2, 4));
    }

    @Test
    public void testP93RestoreIpAddresses() {
        System.out.println(new P93RestoreIpAddresses().restoreIpAddresses("010010"));
    }

}
