package Day_5;

import java.util.Arrays;

class Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {

        int[][][] dp = new int[prices.length][2][3];
        // n X 2 X  3  n for index , 2 for either buy or sell and 3 for capacity like 0 1 and 2 only 
        for(int[][] a : dp){
            for(int[] b : a ){
                Arrays.fill(b , -1);
            }
        }
        
        int ans = max(prices, 0 , 1 , 2 , dp);
        if(ans <0)return 0;
        return ans;
        
    }
    int max(int[] prices ,int i ,  int buy , int cap , int[][][] dp ){

        if(cap == 0 || i == prices.length){
            return 0;
        }
        if(dp[i][buy][cap] != -1 ){
            return dp[i][buy][cap] ;
        }

        
       

        if(buy == 1) {// allow to buy
            int b = -prices[i] + max(prices , i +1 , 0 , cap , dp); // buy 
            int nB = 0 + max(prices , i+1 , 1 , cap , dp);// not buy
            
            return  dp[i][buy][cap] =  Math.max(b , nB);

        }else{
            //only you can sell 

            int s  = prices[i] + max(prices , i+1 , 1 , cap -1  , dp); // sell
            int nS = 0 + max(prices , i+1 , 0 , cap , dp); // noy sell

            return dp[i][buy][cap] = Math.max(s , nS);

        }
     


    }
    // tabulation

    static int maxPro(int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n+1][2][3] initialized to 0
        int[][][] dp = new int[n + 1][2][3];

        // Loop through the dp array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }

        // The maximum profit with 2 transactions is stored in dp[0][0][2]
        return dp[0][0][2];
    }
}