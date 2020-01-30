package src.LeetCode;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

import java.util.*;
public class FindDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List sol = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sol.add(i+1);
            }
        }
        return sol;
    }
}
