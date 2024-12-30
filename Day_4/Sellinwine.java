package Day_4;
import  java.util.*;
public class Sellinwine
{
    public static void main(String[] args) {

        int [] arr = {2,3,5,1,4};
        int[][] dp = new int[arr.length][arr.length];
        for(int[] a : dp){
            Arrays.fill(a , -1);
        }
        int ans = findMax(arr , 0 , arr.length -1 , 1 , dp);
        System.out.println(ans);


    }
    static int findMax(int [] arr , int i , int j  , int year , int[][] dp){

        if( i >j){
            return 0;
        }
        if(i == j){
            return year * arr[i];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int start = year *arr[i] + findMax(arr , i +1 , j , year +1 ,dp);
        int end = year *arr[j] + findMax(arr, i , j-1 , year +1 , dp);

        return dp[i][j] = Math.max(start ,end);

    }
}
