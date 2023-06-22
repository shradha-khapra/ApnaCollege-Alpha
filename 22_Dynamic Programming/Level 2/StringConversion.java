public class StringConversion {
    public static int tab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        int TotalDeleteOperations = str1.length() - dp[n][m];
        // System.out.println(TotalDeleteOperations);
        int TotalAddOperations = str2.length() - dp[n][m];
        // System.out.println(TotalAddOperations);

        return TotalAddOperations + TotalDeleteOperations;
    }

    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "aceg";

        System.out.println(tab(str1, str2));
    }
}
