import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给你一个回文字符串 palindrome ，请你将其中一个字符用任意小写英文字母替换，使得结果字符串的字典序最小，且不是回文串。
 * <p>
 * 请你返回结果字符串。如果无法做到，则返回一个空串。
 */
public class P1328BreakAPalindrome {
    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if (length <= 1) {
            return "";
        }


        for (int i = 0; i < length / 2; i++) {
            char ch = palindrome.charAt(i);
            if (ch > 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }

        return palindrome.substring(0, length - 1) + 'b';

    }

    public static void main(String[] args) {
        System.out.println(new P1328BreakAPalindrome().breakPalindrome("abccba"));
        System.out.println(new P1328BreakAPalindrome().breakPalindrome("a"));
        System.out.println(new P1328BreakAPalindrome().breakPalindrome("aa"));
        System.out.println(new P1328BreakAPalindrome().breakPalindrome("aba"));
        System.out.println(new P1328BreakAPalindrome().breakPalindrome("aaaa"));
    }
}
