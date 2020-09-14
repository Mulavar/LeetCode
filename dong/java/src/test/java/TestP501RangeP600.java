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
}
