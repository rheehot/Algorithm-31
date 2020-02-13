package src.LeetCode;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

import java.util.*;
class BuyAndSell {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int min = prices[0];
        int result = 0;
        
        for(int i = 1; i < prices.length; i++) {
            if (result < (prices[i] - min)) {
                result = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        
        return result;
    }
}