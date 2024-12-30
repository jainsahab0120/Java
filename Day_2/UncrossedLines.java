package Day_2;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        return lcsBU(nums1 , nums2);

    }
    int lcsBU(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // pehle s1 isliye aya kyunki usse row decide ho rhi hai
        // s2 se collumn

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }

        }
        return dp[dp.length - 1][dp[0].length - 1];

    }
}
