public class CoinChange {
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize - sum = 0
        // i -> coins
        // j -> sum/change
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }

        // O(N+SUM)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i - 1] <= j) { // valid
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10; // ans = 5;
        System.out.println(coinChange(coins, sum));
    }
}
