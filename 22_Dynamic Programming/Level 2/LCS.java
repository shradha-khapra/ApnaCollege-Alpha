public class LCS {
    // simple recursive
    public static int lcs(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs(str1, str2, n - 1, m - 1) + 1;
        } else { // diff
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);

            return Math.max(ans1, ans2);
        }
    }

    // memoization
    public static int lcs2(String str1, String str2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcs2(str1, str2, n - 1, m - 1, dp) + 1;
        } else { // diff
            int ans1 = lcs2(str1, str2, n - 1, m, dp);
            int ans2 = lcs2(str1, str2, n, m - 1, dp);

            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        // lcs = "abdg";
        // length = 4;
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        // initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(lcs2(str1, str2, n, m, dp));
    }
}