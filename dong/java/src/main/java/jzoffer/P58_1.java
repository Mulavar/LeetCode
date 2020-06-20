package jzoffer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * @author Lam
 * @date 2020/6/20
 */
public class P58_1 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) != ' ') {
                    j++;
                }
                sb.insert(0, s.substring(i, j) + " ");
                i = j;
            } else {
                i++;
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
