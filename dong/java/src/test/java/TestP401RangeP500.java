import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lam
 * @date 2020/6/3
 */
public class TestP401RangeP500 {

    @Test
    public void testP402RemoveKDigits() {
        Assert.assertEquals("200", new P402RemoveKDigits().removeKdigits("10200", 1));
    }

    @Test
    public void testP406QueueReconstructionByHeight() {
        int[][] people = new int[][]{
                {7, 0},
                {4, 4},
                {7,1},
                {5, 0},
                {6, 1},
                {5, 2},
        };
        System.out.println(Arrays.deepToString(new P406QueueReconstructionByHeight().reconstructQueue(people)));
    }

    @Test
    public void testP440KthSmallestInLexicographicalOrder() {
        Assert.assertEquals(10, new P440KthSmallestInLexicographicalOrder().findKthNumber(13, 2));
        Assert.assertEquals(20, new P440KthSmallestInLexicographicalOrder().findKthNumber(30, 13));
        Assert.assertEquals(17, new P440KthSmallestInLexicographicalOrder().findKthNumber(100, 10));
    }
}
