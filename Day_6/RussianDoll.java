package Day_6;
import  java.util.*;
public class RussianDoll {
//a[0] == b[0]:
//
//This checks if the widths of the two envelopes a and b are the same.
//b[1] - a[1]:
//
//If the widths are the same, this sorts the heights (a[1] and b[1]) in descending order.
//b[1] - a[1] ensures that a larger height comes before a smaller height.
//a[0] - b[0]:
//
//If the widths are different, this sorts the widths in ascending order.

    //Why Sort Heights in Descending Order?
    //The descending order of heights for envelopes with the same width is crucial for the Longest Increasing Subsequence (LIS) solution.
    //It ensures that when we process the heights array, we don’t mistakenly count envelopes with the same width but increasing heights as valid "nested" envelopes.
    //This trick simplifies the LIS calculation, as we only need to focus on increasing heights.

        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int[] heights = new int[envelopes.length];
            for (int i = 0; i < envelopes.length; i++) {
                heights[i] = envelopes[i][1];
            }

            return lengthOfLIS(heights);
        }

        private int lengthOfLIS(int[] nums) {
            int[] lis  = new int[nums.length+1];
            lis[0] = nums[0];
            int len = 1;


            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] > lis[len-1]){
                    lis[len] = nums[i];
                    len++;
                }else {
                    int idx =  BinarySearch(lis, 0, len - 1, nums[i]);
                    lis[idx] = nums[i];

                }


            }



            return len;
        }
        private static int BinarySearch(int[] lis, int lo, int hi, int target) {

            while(lo <= hi){
                int mid = (hi+lo)/2;

                if(lis[mid] < target){
                    lo = mid+1;

                }
                else {
                    hi = mid -1;
                }
            }
            return lo;


        }
    }
