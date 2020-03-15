/**
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
 * 每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
 * 有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 你的朋友将会根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 *
 * @author Lam
 * @ClassName P299BullsAndCows
 * @date 2020/2/25
 */
public class P299BullsAndCows {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        int[] count = new int[10];
        for (int i = 0; i < length; i++) {
            count[secret.charAt(i) - '0']++;
        }

        int a = 0;
        int b = 0;
        for (int i = 0; i < length; i++) {
            int num = guess.charAt(i) - '0';
            if (secret.charAt(i) - '0' == num) {
                a++;
                if (count[num] == 0) {
                    b--;
                } else {
                    count[num]--;
                }
            } else if (count[num] > 0) {
                count[num]--;
                b++;
            }
        }

        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(new P299BullsAndCows().getHint(secret, guess));
    }
}
