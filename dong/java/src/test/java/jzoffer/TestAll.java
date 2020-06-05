package jzoffer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lam
 * @ClassName TestAll
 * @date 2020/6/5
 */
public class TestAll {

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
}
