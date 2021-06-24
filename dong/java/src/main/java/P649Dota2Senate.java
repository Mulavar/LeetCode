import java.util.LinkedList;
import java.util.Queue;

public class P649Dota2Senate {
    public String predictPartyVictory(String senate) {
        int curDCount = 0;
        Queue<Character> queue = new LinkedList<>();

        // 总共的D和R数目
        int rCount = 0;
        int dCount = 0;

        for (int i = 0; i < senate.length(); i++) {
            queue.offer(senate.charAt(i));
            if (senate.charAt(i) == 'R') {
                rCount++;
            } else {
                dCount++;
            }
        }

        // 已经被ban的D和R数目
        int bannedD = 0;
        int bannedR = 0;

        while (bannedD < dCount && bannedR < rCount) {
            Queue<Character> next = new LinkedList<>();
            while (!queue.isEmpty()) {
                char ch = queue.poll();
                if (ch == 'R') {
                    curDCount--;
                    if (curDCount < 0) {
                        bannedD++;
                        next.offer(ch);
                    }
                } else {
                    curDCount++;
                    if (curDCount > 0) {
                        bannedR++;
                        next.offer(ch);
                    }
                }
            }
            queue = next;
        }

        if (bannedD>=dCount) {
            return "Radiant";
        }

        return "Dire";
    }
}
