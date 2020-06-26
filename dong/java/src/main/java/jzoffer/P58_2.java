package jzoffer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * @author Lam
 * @date 2020/6/26
 */
public class P58_2 {
    public String reverseLeftWords(String s, int n) {
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, n-1);
        reverse(charArray, n, charArray.length-1);
        reverse(charArray, 0, charArray.length-1);
        return new String(charArray);
    }

    private void reverse(char[] array, int left, int right) {
        while (left<right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
