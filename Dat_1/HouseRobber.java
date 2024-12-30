package Dat_1;

import java.util.Arrays;

//leetcode
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2 ,3 ,4}));
    }

    public static int rob(int[] nums) {
        int[] dp  = new int[nums.length +1];
        Arrays.fill(dp , -1);

        int ans = chor(nums , 0 , dp);
        return ans;

    }
    // topdown
    public static int chor(int [] nums , int i , int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){ // apply kiya
            return dp[i];
        }

        int robbed = chor(nums , i+2 , dp) + nums[i];
        int notRobbed = chor(nums , i+1 , dp) ;

        return dp[i] =  Math.max(robbed , notRobbed); // yaad




    }
    // bottom up
    int chor2(int[] nums){
        // ek hi hai to loot lo
        if(nums.length == 1){
            return nums[0];
        }
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0] , nums[1]);


        for(int i = 2 ; i < dp.length ; i++){
            int robbed = dp[i-2]  + nums[i];
            int notRobbed = dp[i-1];

            dp[i] =  Math.max(robbed , notRobbed);
        }
        return dp[dp.length - 1];


    }
}
