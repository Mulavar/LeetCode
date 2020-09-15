import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Lam
 * @date 2020/5/23
 */
public class TestOver1000 {
    @Test
    public void testP1028RecoverATreeFromPreorderTraversal() {
        System.out.println(new P1028RecoverATreeFromPreorderTraversal().recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println(new P1028RecoverATreeFromPreorderTraversal().recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println(new P1028RecoverATreeFromPreorderTraversal().recoverFromPreorder("10-6--10---10"));
    }

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

    @Test
    public void testP1439FindTheKthSmallestSumOfAMatrixWithSortedRows() {
        int[][] matrix = new int[][]{
                {1, 3, 11}, {2, 4, 6}
        };

        Assert.assertEquals(17, new P1439FindTheKthSmallestSumOfAMatrixWithSortedRows().kthSmallest(matrix, 9));
        Assert.assertEquals(17, new P1439FindTheKthSmallestSumOfAMatrixWithSortedRows().kthSmallest1(matrix, 9));
        Assert.assertEquals(7, new P1439FindTheKthSmallestSumOfAMatrixWithSortedRows().kthSmallest1(matrix, 5));
    }
}
