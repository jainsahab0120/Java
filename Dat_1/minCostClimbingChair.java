package Dat_1;

import java.util.Arrays;
//leetcode
public class minCostClimbingChair {

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp= new int[cost.length];
            Arrays.fill(dp , -1);

            // return Math.min(minCost(cost , dp, 0 ),minCost(cost , dp, 1 )) ;
            return min(cost);


        }
        // bottom up
        int min(int[] cost) {
            if (cost.length == 2) {
                return Math.min(cost[0], cost[1]);
            }

            int[] dp = new int[cost.length];

            dp[0] = cost[0];
            dp[1] = cost[1];

            for (int i = 2; i < cost.length; i++) {
                int ONE = dp[i - 1] + cost[i];
                int TWO = dp[i - 2] + cost[i];
                dp[i] = Math.min(ONE, TWO);
            }
            return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
        }



        int minCost(int[] cost , int[] dp , int i ){
            if( i >= cost.length){
                return 0;
            }
            if(dp[i] != -1){
                return dp[i];
            }



            int ONE = minCost( cost , dp , i+2)+ cost[i];
            int TWO = minCost(cost , dp  , i+1) + cost[i] ;
            return dp[i] =  Math.min(ONE , TWO);
        }
    }
}
