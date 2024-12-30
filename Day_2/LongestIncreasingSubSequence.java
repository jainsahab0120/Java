package Day_2;

import java.util.Arrays;

public class LongestIncreasingSubSequence {



        public int lengthOfLIS(int[] nums) {
            int[] lisArr = new int[nums.length];
            Arrays.fill(lisArr , 1);

            for(int i = 1 ; i < nums.length ; i++){
                for(int j = i-1 ; j >= 0 ; j--){

                    if(nums[j] < nums[i]){
                        lisArr[i] = Math.max(lisArr[i] , lisArr[j]+ 1);
                    }
                }
            }
            int ans = lisArr[0];
            for(int i = 1 ; i< nums.length ; i++){
                ans = Math.max(ans , lisArr[i]);
            }
            return ans;

        }

}
