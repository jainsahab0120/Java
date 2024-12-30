package Day_4;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class lisNlogN {

    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11, 7, 15};
        int ans = LIS(arr);
        System.out.println(ans);

    }

    public static int LIS (int[] arr){


        int[] lis  = new int[arr.length];
        lis[0] = arr[0];
        int len = 1;


        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] >lis[len-1]){
                lis[len] = arr[i];
                len++;
            }else {
                int idx = BinarySearch(lis, 0, len - 1, arr[i]);
                lis[idx] = arr[i];

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
