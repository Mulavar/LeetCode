/**
 * @(#)P621.java, 6月 10, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
 * @author dongjianhui
 */
public class P621TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        if (n == 0) {
            return m;
        }

        int[] taskCount = new int[26];
        for (int i = 0; i < m; i++) {
            taskCount[tasks[i] - 'A']++;
        }

        Arrays.sort(taskCount);
        
        int maxCount = 1;
        for (int i = 25; i >= 1; i--) {
            if (taskCount[i] == taskCount[i - 1]) {
                maxCount++;
            } else {
                break;
            }
        }

        int result = maxCount + (taskCount[25] - 1) * (n + 1);
        // m 表示有很多任务种类，任务穿插执行就能度过冷却时间
        return Math.max(result, m);
    }

}