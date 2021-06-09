/**
 * @(#)P342wuchongdie.java, 6月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;

/**
 * @author dongjianhui
 */
public class P435NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int end = intervals[0][1];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            // there is conflict
            if (intervals[i][0] < end) {
                result++;
                end = Math.min(intervals[i][1], end);
            } else {
                end = intervals[i][1];
            }
        }

        return result;
    }

}