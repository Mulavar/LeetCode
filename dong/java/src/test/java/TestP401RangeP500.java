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
}
