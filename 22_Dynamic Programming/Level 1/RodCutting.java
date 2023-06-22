public class RodCutting {
    // weight -> lenght;
    // val -> price;
    // W -> totRod;
    public static int rodCutting(int[] length, int[] price, int totRod) {
        int n = price.length;
        int[][] dp = new int[n + 1][totRod + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totRod; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totRod; j++) {
                // valid
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][totRod];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 }; // Pieces length
        int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totRod = 8;
    }
}
