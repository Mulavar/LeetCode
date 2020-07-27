/**
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 *
 * @author Lam
 * @date 2020/7/25
 */
public class P243ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (idx2 != -1) {
                    result = Math.min(i - idx2, result);
                }
                idx1 = i;
            } else if (words[i].equals(word2)) {
                if (idx1 != -1) {
                    result = Math.min(i - idx1, result);
                }
                idx2 = i;
            }

        }

        return result;
    }
}
