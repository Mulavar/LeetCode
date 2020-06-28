package jzoffer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lam
 * @ClassName TestAll
 * @date 2020/6/5
 */
public class TestAll {
    int[][] matrix;

    @Before
    public void prepare() {
        matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };
    }

    @Test
    public void testP29() {
        System.out.println(Arrays.toString(new P29().spiralOrder(matrix)));
    }

    @Test
    public void testP31() {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] poped = new int[]{4, 5, 3, 2, 1};
        Assert.assertTrue(new P31().validateStackSequences(pushed, poped));

        poped = new int[]{4, 5, 3, 1, 2};
        Assert.assertFalse(new P31().validateStackSequences(pushed, poped));

        pushed = new int[]{1, 0};
        poped = new int[]{1, 0};
        Assert.assertTrue(new P31().validateStackSequences(pushed, poped));
    }

    @Test
    public void testP33() {
        int[] postorder = new int[]{1, 2, 5, 10, 6, 9, 4, 3};
        Assert.assertFalse(new P33().verifyPostorder(postorder));
        Assert.assertFalse(new P33().verifyPostorder1(postorder));
    }

    @Test
    public void testP47() {
        int[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        System.out.println(new P47().maxValue(matrix));
    }

    @Test
    public void testP51() {
        int[] nums = {
                3, 2, 4, 6, 5, 1
        };

        int[] nums1 = new int[]{
                3, 2, 4, 6, 5, 1
        };

        Assert.assertEquals(new P51().reversePairs(nums), new P51().reversePairs1(nums1));
    }

    @Test
    public void testP56_1() {
        int[] nums = {4, 1, 4, 5};
        System.out.println(Arrays.toString(new P56_1().singleNumbers(nums)));
    }

    @Test
    public void testP56_2() {
        int[] nums = {3, 4, 3, 3};
        System.out.println(new P56_2().singleNumber(nums));
    }

    @Test
    public void testP57_2() {
        int target = 9;
        System.out.println(Arrays.deepToString(new P57_2().findContinuousSequence(target)));
    }

    @Test
    public void testP58_1() {
        String s = " hello world.";
        System.out.println(new P58_1().reverseWords(s));
    }

    @Test
    public void testP59_1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(new P59_1().maxSlidingWindow(nums, k)));

        nums = new int[]{1, 3, 1, 2, 0, 5};
        System.out.println(Arrays.toString(new P59_1().maxSlidingWindow(nums, k)));

    }
}
