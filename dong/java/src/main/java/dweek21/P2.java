package dweek21;

import java.util.Arrays;

/**
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：
 * 每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 * @author Lam
 * @ClassName P2
 * @date 2020/3/7
 */
public class P2 {
    //状态压缩dp
    public int findTheLongestSubstring(String s) {
        //state数组用于记录每种情况第一次出现的位置
        //***难点：如何记录状态？使用异或
        //state[0]即表示0状态（所有元音字母出现偶数次）最早出现的位置
        int[] state = new int[32];
        Arrays.fill(state, -2);
        state[0] = -1;
        int curState = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    curState ^= 1;
                    break;
                case 'e':
                    curState ^= 2;
                    break;
                case 'i':
                    curState ^= 4;
                    break;
                case 'o':
                    curState ^= 8;
                    break;
                case 'u':
                    curState ^= 16;
                    break;
                default:
                    break;
            }
            if (state[curState] == -2) {
                //第一次出现该状态
                state[curState] = i;
            } else {
                //不是第一次出现
                result = Math.max(result, i - state[curState]);
            }
        }
        return result;
    }
}
