package src.LeetCode;

/**
 * https://leetcode.com/problems/two-sum/
 */

import java.util.*;
public class TwoSum {

    public int[] twoSumFirst(int[] nums, int target) {
        int[] sol = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sol[0] = i;
                    sol[1] = j;
                    break;
                }
            }
        }

        return sol;
    }

    public int[] twoSumSecond(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
