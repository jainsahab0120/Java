package Day_3;
import java.util.Arrays;
public class EditDistance {

}class Solution {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int [word1.length() +1 ][word2.length()+1];

        for(int[] a : dp){
            Arrays.fill(a , -1);
        }

        return min(word1  , word2, 0 , 0, dp);


    }

    int  min(String s , String t , int i , int j , int[][] dp){


        if(i == s.length()){
            return t.length() - j;
        }

        if(j ==  t.length()){
            return s.length () - i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;

        if(s.charAt(i) == t.charAt(j)){
            ans = min(s, t, i+1 , j+1, dp);
        }
        else{

            int D = min(s, t, i+1 , j , dp);
            int I = min(s, t, i, j+1 , dp);
            int R = min(s, t, i+1 , j+1 , dp);
            ans = 1 + Math.min(D, Math.min(I, R));
        }
        return dp[i][j] = ans;
    }
}
