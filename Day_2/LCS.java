package Day_2;

import java.util.Arrays;
//1143
public class LCS {
    //longestcommon subsequence 1143

    public static void main(String[] args) {

    }
    public int longestCommonSubsequence(String text1, String text2) {

        // i-- s1
        // j -- s2
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        // return lcs(text1, text2, 0, 0, dp);
        return lcsBU(text1, text2);

    }

    int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if (s1.length() == i || s2.length() == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans += 1 + lcs(s1, s2, i + 1, j + 1, dp);
        } else {
            int f = lcs(s1, s2, i + 1, j, dp);
            int s = lcs(s1, s2, i, j + 1, dp);
            ans = Math.max(f, s);
        }
        return dp[i][j] = ans;

    }

    // lcs bootom up
    int lcsBU(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // pehle s1 isliye aya kyunki usse row decide ho rhi hai
        // s2 se collumn

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }

        }
        return dp[dp.length - 1][dp[0].length - 1];

    }

}
