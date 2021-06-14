/**
 * @(#)P659SplitArrayIntoConsecutiveSubsequences.java, 6月 14, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author dongjianhui
 */
public class P659SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        // x -> 以x为结尾的序列长度数组
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            if (map.containsKey(nums[i] - 1)) {
                PriorityQueue<Integer> lens = map.get(nums[i] - 1);
                if (lens.isEmpty()) {
                    map.remove(nums[i] - 1);
                } else {
                    len = lens.poll() + 1;
                }
            }

            PriorityQueue<Integer> lens = map.getOrDefault(nums[i], new PriorityQueue<>());
            lens.offer(len);
            map.put(nums[i], lens);
        }

        return map.values().stream().noneMatch(v -> v.stream().anyMatch(len -> len < 3));
    }
}