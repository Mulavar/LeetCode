import bean.TrieTreeNode;

import java.util.Collections;
import java.util.List;

/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，
 * 该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。
 * 如果答案不存在，则返回空字符串。
 *
 * @author Lam
 * @ClassName P524LongestWordInDictionaryThroughDeleting
 * @date 2020/9/13
 */
public class P524LongestWordInDictionaryThroughDeleting {
    /**
     * 排序+子序列对比
     */
    public String findLongestWord(String text, List<String> targets) {
        Collections.sort(targets, (w1, w2) -> {
            if (w1.length() != w2.length()) {
                return w2.length() - w1.length();
            }

            return w1.compareTo(w2);
        });

        for (int i = 0; i < targets.size(); i++) {
            if (isSubsequence(text, targets.get(i))) {
                return targets.get(i);
            }
        }

        return "";
    }

    public String findLongestWord1(String text, List<String> targets) {
        String result = "";
        for (String target : targets) {
            if (isSubsequence(text, target)) {
                if (target.length() > result.length() || (target.length() == result.length() && target.compareTo(result) < 0)) {
                    result = target;
                }
            }
        }
        return result;
    }

    /**
     * 双指针比对子序列
     */
    private boolean isSubsequence(String text, String pattern) {
        int i = 0;
        int j = 0;
        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == pattern.length();
    }


    /**
     * *************************************
     * 下面是字典树解法，会导致超时
     * *************************************
     */
    TrieTreeNode root;

    public String findLongestWord2(String text, List<String> targets) {
        this.root = buildTree(targets);
        return searchLongestWord(root, text, 0);
    }

    private String searchLongestWord(TrieTreeNode node, String text, int idx) {
        if (idx == text.length()) {
            return node.getValue() != null ? node.getValue() : "";
        }

        char ch = text.charAt(idx);
        String word1 = node.getChildren()[ch] != null ? searchLongestWord(node.getChildren()[ch], text, idx + 1) : "";
        String word2 = searchLongestWord(node, text, idx + 1);
        if (word1.length() == word2.length()) {
            return word1.compareTo(word2) <= 0 ? word1 : word2;
        }

        return word1.length() > word2.length() ? word1 : word2;
    }

    private TrieTreeNode buildTree(List<String> words) {
        TrieTreeNode root = new TrieTreeNode();
        for (String word :
                words) {
            insert(root, word);
        }

        return root;
    }

    private void insert(TrieTreeNode root, String word) {
        TrieTreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.getChildren()[ch] == null) {
                cur.getChildren()[ch] = new TrieTreeNode();
            }

            cur = cur.getChildren()[ch];
        }
        cur.setValue(word);
    }
}
