import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * Tips：使用回溯法， ****需要注意哪些ip格式是合法的****
 *
 * @author Lam
 * @date 2020/5/3
 */
public class P93RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        backtrace(result, new StringBuilder(), s, 0, 4);
        return result;
    }

    private void backtrace(List<String> result, StringBuilder sb, String s, int idx, int k) {
        if (s.length() - idx > 3 * k) {
            return;
        }

        if (k == 0) {
            //idx must equal s.length()
            result.add(sb.substring(0, sb.length() - 1));
            return;
        }

        for (int i = 1; i <= 3 && idx + i <= s.length(); i++) {
            String ipStr = s.substring(idx, idx + i);
            //001是非法的，0开头的ip长度必须不超过1
            if (ipStr.startsWith("0") && ipStr.length() > 1 || Integer.parseInt(ipStr) > 255) {
                continue;
            }
            int st = sb.length();
            sb.append(ipStr + ".");
            backtrace(result, sb, s, idx + i, k - 1);
            sb.delete(st, sb.length());
        }
        return;
    }

}
