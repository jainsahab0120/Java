package Day_5;
import java.util.*;
public class BuyAndStockFive {
    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length +1][2];
        // n X 2   n for index , 2 for either buy or sell
        for(int[] a : dp){

            Arrays.fill(a , -1);

        }

        int ans = max(prices, 0 , 1 , dp);
        if(ans <0)return 0;
        return ans;

    }

    int max(int[] prices ,int i ,  int buy , int[][] dp ){

        if( i >= prices.length){
            return 0;
        }
        if(dp[i][buy] != -1 ){
            return dp[i][buy] ;
        }




        if(buy == 1) {// allow to buy
            int b = -prices[i] + max(prices , i +1 , 0 , dp); // buy
            int nB = 0 + max(prices , i+1 , 1 ,  dp);// not buy

            return  dp[i][buy] =  Math.max(b , nB);

        }else{
            //only you can sell

            int s  = prices[i] + max(prices , i+2 , 1 ,  dp); // sell
            int nS = 0 + max(prices , i+1 , 0 ,  dp); // noy sell

            return dp[i][buy] = Math.max(s , nS);

        }



    }

}
