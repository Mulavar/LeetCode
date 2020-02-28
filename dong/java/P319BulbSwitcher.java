/**
 * 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。
 * 第 2 轮，每两个灯泡你关闭一次。
 * 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。
 * 第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
 *
 * @author Lam
 * @ClassName P319BulbSwitcher
 * @date 2020/2/28
 */
public class P319BulbSwitcher {
    public int bulbSwitch(int n) {
        int i = 1;
        while (i * i <= n) {
            i++;
        }
        return i - 1;
    }
}
