package dweek21;

/**
 * @author Lam
 * @ClassName P1
 * @date 2020/3/7
 */
public class P1 {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] map = new int[30];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        int cnt = s.length();
        while (cnt > 0) {
            for (int i = 0; i < map.length; i++) {
                if (map[i] != 0) {
                    sb.append((char)(i + 'a'));
                    map[i]--;
                    cnt--;
                }
            }
            for (int i=map.length-1;i>=0;i--) {
                if (map[i] != 0) {
                    sb.append((char)(i + 'a'));
                    map[i]--;
                    cnt--;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P1().sortString("leetcode"));
    }
}
