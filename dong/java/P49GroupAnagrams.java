import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Lam
 * @ClassName P49GroupAnagrams
 * @date 2020/2/12
 */
public class P49GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            ArrayList<List<String>> result = new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<String, List<String>>();
            for (int i = 0; i < strs.length; i++) {
                String key = sort(strs[i]);
                if (map.containsKey(key)) {
                    map.get(strs[i]).add(strs[i]);
                } else {
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.add(strs[i]);
                    map.put(key, tmp);
                }
            }
            for (List<String> value : map.values()) {
                result.add(value);
            }
            return result;
        }

        private String sort(String origin) {
            char[] chars = origin.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }
}
