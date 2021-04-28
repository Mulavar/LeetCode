import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lam
 * @date 2020/7/8
 */
public class TestP501RangeP600 {

    @Test
    public void testP518CoinChangeII() {
        int[] coins = new int[]{1, 2, 5};
        Assert.assertEquals(4, new P518CoinChangeII().change(5, coins));
        coins = new int[]{2};
        Assert.assertEquals(0, new P518CoinChangeII().change(3, coins));
    }

    @Test
    public void testP524LongestWordInDictionaryThroughDeleting() {
        String text = "abpcplea";
        List<String> words = Arrays.asList("ale", "apple", "monkey", "plea");

        Assert.assertEquals("apple", new P524LongestWordInDictionaryThroughDeleting().findLongestWord(text, words));

        Assert.assertEquals("a", new P524LongestWordInDictionaryThroughDeleting().findLongestWord(text, Arrays.asList("a", "b", "c")));

    }

    @Test
    public void testP525ContiguousArray() {
        Assert.assertEquals(2, new P525ContiguousArray().findMaxLength(new int[]{1, 0}));
        Assert.assertEquals(2, new P525ContiguousArray().findMaxLength(new int[]{0, 1, 0}));
    }

    @Test
    public void testP547FriendCircles() {
        int[][] M = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };
        Assert.assertEquals(1, new P547FriendCircles().findCircleNum(M));
    }
}
