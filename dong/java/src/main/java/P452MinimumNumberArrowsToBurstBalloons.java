/**
 * @(#)P452Qiqiu.java, 6月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Arrays;

/**
 * @author dongjianhui
 */
public class P452MinimumNumberArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }

        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return Integer.compare(p1[0], p2[0]);
            }

            return Integer.compare(p1[1], p2[1]);
        });

        int end = points[0][1];
        int result = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = Math.min(points[i][1], end);
            } else {
                end = points[i][1];
                result++;
            }
        }

        return result;
    }

}