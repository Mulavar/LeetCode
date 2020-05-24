import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lam
 * @date 2020/5/23
 */
public class TestOver1000 {
    @Test
    public void testP1143LongestCommonSubsequence() {
        String text1 = "abc";
        String text2 = "kafbdc";
        Assert.assertEquals(3, new P1143LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
        Assert.assertEquals(3, new P1143LongestCommonSubsequence().longestCommonSubsequence1(text1, text2));
        text1 = "abcde";
        text2 = "ace";
        Assert.assertEquals(3, new P1143LongestCommonSubsequence().longestCommonSubsequence1(text1, text2));
        text1 = "pmjghexybyrgzczy";
        text2 = "hafcdqbgncrcbihkd";
        Assert.assertEquals(4, new P1143LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
        Assert.assertEquals(4, new P1143LongestCommonSubsequence().longestCommonSubsequence1(text1, text2));
    }
}
