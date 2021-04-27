import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lam
 * @date 2020/7/8
 */
public class TestP900RangeP1000 {

    @Test
    public void testP962MaximumWidthRamp() {
        Assert.assertEquals(4, new P962MaximumWidthRamp().maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
        Assert.assertEquals(3, new P962MaximumWidthRamp().maxWidthRamp(new int[]{2, 4, 1, 3}));
    }
}
