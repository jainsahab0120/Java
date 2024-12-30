package Day_3;
import java.util.*;
public class MinFallingPAthSum2 {


    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int[] a:dp){
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, fallingPathSum2(grid, 0, i, dp));
        }
        return ans;
    }
    public static int fallingPathSum2(int[][] grid, int cr, int cc, int[][] dp){
        if(cr == grid.length-1){
            return grid[cr][cc];
        }
        if(dp[cr][cc] != Integer.MAX_VALUE){
            return dp[cr][cc];
        }
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col < grid[0].length; col++){
            if(col == cc){
                continue;
            }
            ans = Math.min(ans, fallingPathSum2(grid, cr+1, col, dp));
        }
        return dp[cr][cc] = ans += grid[cr][cc];
    }
}
