package Dat_1;
// leetcode 334

public class IncreasingTripletSubsequence {

        public boolean increasingTriplet(int[] nums) {

            // tle at 75 / 84
            // int[] lisArr = new int[nums.length];
            // Arrays.fill(lisArr , 1);

            //  for(int i = 1 ; i < nums.length ; i++){
            //     for(int j = i-1 ; j >= 0 ; j--){

            //         if(nums[j] < nums[i]){
            //             lisArr[i] = Math.max(lisArr[i] , lisArr[j]+ 1);
            //         }
            //     }
            //  }
            // //  int ans = lisArr[0];
            //  for(int i = 0 ; i< nums.length ; i++){
            //     if(lisArr[i] == 3){
            //         return true;
            //     }
            //  }
            //  return false;
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for(int n : nums) {
                if(n <= min1) min1 = n;
                else if(n <= min2) min2 = n;
                else return true;
            }
            return false;




    }
}
