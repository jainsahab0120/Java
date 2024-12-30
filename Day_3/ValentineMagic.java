package Day_3;

import java.util.*;

public class ValentineMagic {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] choc = new int[n];
        for (int i = 0; i < n; i++) {
            choc[i] = sc.nextInt();
        }

        int[] candie = new int[m];
        for (int i = 0; i < m; i++) {
            candie[i] = sc.nextInt();
        }

        Arrays.sort(choc);
        Arrays.sort(candie);

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(min(choc, candie, 0, 0, dp));
    }

    public static int min(int[] boys, int[] girls, int i, int j, int[][] dp) {
        if (i == boys.length) {
            return 0;
        }
        if (j == girls.length) {
            return 100000;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int pair = Math.abs(boys[i] - girls[j]) + min(boys, girls, i + 1, j + 1, dp);
        int notPair = min(boys, girls, i, j + 1, dp);

        dp[i][j] = Math.min(pair, notPair);
        return dp[i][j];
    }
}
