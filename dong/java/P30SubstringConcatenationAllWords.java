import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s
 * that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 *
 * @author Lam
 * @ClassName P30SubstringConcatenationAllWords
 * @date 2020/2/12
 */
public class P30SubstringConcatenationAllWords {
    class Solution {
        /**
         * sliding window 滑动窗口法
         */
        public List<Integer> findSubstring(String s, String[] words) {
            int wNum = words.length;
            int len = s.length();
            List<Integer> result = new ArrayList<>();
            if (len == 0 || wNum == 0) {
                return result;
            }

            int wordLen = words[0].length();
            int totalWordsLen = wordLen * wNum;
            // 记录words的 word->count 映射
            HashMap<String, Integer> wordsMap = new HashMap<>();
            for (String word : words) {
                wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
            }

            int count;
            int start = 0;
            while (start < len - totalWordsLen + 1) {
                // 不能重用原来的map
                HashMap<String, Integer> curMap = new HashMap<>();
                count = wordsMap.size();
                int end = start + wordLen - 1;
                while (end < len) {
                    String subS = s.substring(end + 1 - wordLen, end + 1);
                    if (!wordsMap.containsKey(subS)) {
                        break;
                    }

                    int cnt = curMap.getOrDefault(subS, 0);
                    curMap.put(subS, cnt + 1);
                    if (wordsMap.get(subS) < cnt + 1) {
                        break;
                    } else if (wordsMap.get(subS) == cnt + 1) {
                        count--;
                    }

                    if (count == 0) {
                        result.add(start);
                        break;
                    }
                    end += wordLen;
                }

                start++;
            }

            return result;
        }
    }

    class Solution1 {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (words.length == 0) {
                return result;
            }

            Map<String, Integer> originalMap = new HashMap<>();
            for (String str : words) {
                originalMap.put(str, originalMap.getOrDefault(str, 0) + 1);
            }

            int wordLength = words[0].length();
            int targetLength = wordLength * words.length;

            // we are incrementing by wordLength, thus to cover all cases we will need this outside loop
            // for different starting positions
            for (int start = 0; start < wordLength; start++) {
                int l = start;
                int count = 0;
                Map<String, Integer> currentMap = new HashMap<>();

                for (int r = wordLength + start - 1; r < s.length(); r += wordLength) {
                    String substringEndingAtRightPointer = s.substring(r + 1 - wordLength, r + 1);
                    if (originalMap.containsKey(substringEndingAtRightPointer)) {
                        currentMap.put(substringEndingAtRightPointer, currentMap.getOrDefault(substringEndingAtRightPointer, 0) + 1);
                        if (originalMap.get(substringEndingAtRightPointer) - currentMap.get(substringEndingAtRightPointer) >= 0) {
                            count++;
                        }
                    }

                    if (r - l + 1 == targetLength) {
                        if (count == words.length) {
                            result.add(l);
                        }

                        String substringStartAtLeftPointer = s.substring(l, l + wordLength);
                        if (originalMap.containsKey(substringStartAtLeftPointer)) {
                            currentMap.put(substringStartAtLeftPointer, currentMap.getOrDefault(substringStartAtLeftPointer, 0) - 1);
                            if (originalMap.get(substringStartAtLeftPointer) - currentMap.get(substringStartAtLeftPointer) >= 1) {
                                count--;
                            }
                        }

                        l += wordLength;
                    }
                }
            }

            return result;
        }
    }

    class Solution2 {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (s.isEmpty() || words.length == 0) return result;

            int n = s.length();
            int wordLength = words[0].length();
            int wordTotalLength = words.length * wordLength;

            for (int i = 0; i <= n - wordTotalLength; i++) {
                if (isValidConcatenation(s.substring(i, i + wordTotalLength), words, wordLength)) {
                    result.add(i);
                }
            }
            return result;
        }

        private boolean isValidConcatenation(String s, String[] words, int wordLength) {
            Set<Integer> matchedIndices = new HashSet<>();
            for (String word : words) {
                int indice = s.indexOf(word);

                while (indice != -1 && (indice % wordLength != 0 || matchedIndices.contains(indice))) {
                    indice = s.indexOf(word, indice + 1);
                }
                if (indice == -1) return false;

                matchedIndices.add(indice);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        String[] words = new String[]{"aa", "aa"};
        System.out.println(new P30SubstringConcatenationAllWords().new Solution().findSubstring(s, words));
    }
}
