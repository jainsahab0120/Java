package Dat_1;

import java.util.Arrays;

public class fibonacci {
    public static void main(String[] args) {
        int n= 5;

        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);


        int ans = fibTD(n, dp);
        System.out.println(ans);

        int answer2 = fibBU(n);
        // bottom up approach
        System.out.println(answer2);



    }
    // topdown
    public static int fibTD(int n, int[] dp) {
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n] != -1){
            // dp apply kra
            return dp[n];
        }
        int f1 = fibTD(n-1 , dp);
        int f2 = fibTD(n-2 , dp);
        // yaad kra
        return dp[n] = f1+ f2;

    }
    public static int fibBU(int n){
        int [] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++ ){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
