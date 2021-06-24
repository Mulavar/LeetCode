/**
 * @(#)P502IPO.java, 6月 15, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 某资本家有初始资本 w ，最多可以投资 k 个项目，数组 profits 记录每个所有的纯利润（利润-成本，因此计算过程中无需再减成本）
 * capital 记录每个项目的成本，求资本家最多能赚到的钱。
 *
 * @author dongjianhui
 */
public class P502IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int result = w;

        // 资本承受范围下纯利润按降序排序
        PriorityQueue<Integer> maxProfitQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        // 资本承受范围外成本按升序排序
        PriorityQueue<int[]> unsupportedQueue = new PriorityQueue<>((Comparator.comparingInt(o -> o[0])));

        int length = profits.length;
        for (int i = 0; i < length; i++) {
            if (capital[i] <= w) {
                maxProfitQueue.offer(profits[i]);
            } else {
                unsupportedQueue.offer(new int[]{capital[i], profits[i]});
            }
        }

        while (k-- > 0 && !maxProfitQueue.isEmpty()) {
            result += maxProfitQueue.poll();
            // 手头钱多了后把干得起的项目放到 maxProfitQueue 中
            while (!unsupportedQueue.isEmpty() && unsupportedQueue.peek()[0] <= result) {
                maxProfitQueue.offer(unsupportedQueue.poll()[1]);
            }
        }

        return result;
    }

}