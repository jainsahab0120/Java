package Day_2;

public class Knapsack {


}
class Solution {
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = -1;
            }
        }

        return knap(capacity, val, wt, 0, dp);
    }

    static int knap(int capacity, int val[], int wt[], int i, int[][] dp) {
        if (capacity <= 0 || i >= val.length) {
            return 0;
        }

        if (dp[i][capacity] != -1) {
            return dp[i][capacity];
        }

        int exc = knap(capacity, val, wt, i + 1, dp);

        int inc = 0;
        if (capacity >= wt[i]) {
            inc = val[i] + knap(capacity - wt[i], val, wt, i + 1, dp);
        }

        dp[i][capacity] = Math.max(inc, exc);
        return dp[i][capacity];
    }
}


