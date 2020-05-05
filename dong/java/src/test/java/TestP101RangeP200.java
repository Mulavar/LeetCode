import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lam
 * @ClassName TestP101RangeP200
 * @date 2020/5/4
 */
public class TestP101RangeP200 {

    @Test
    public void testP135Candy() {
        int[] grades = new int[]{29, 51, 87, 87, 72, 12};
        Assert.assertEquals(12 ,new P135Candy().candy(grades));
        Assert.assertEquals(12 ,new P135Candy().candy1(grades));
        Assert.assertEquals(4 ,new P135Candy().candy2(new int[]{1, 2, 2}));
    }

    @Test
    public void testP188BestTimeToBuyAndSellStockIV() {
        System.out.println(new P188BestTimeToBuyAndSellStockIV().maxProfit(4, new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
