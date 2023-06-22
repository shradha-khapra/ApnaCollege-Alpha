public class TargetSumSubset {
    public static boolean tabular(int[] arr, int sum) { // O(n*sum)
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        // i -> item && j -> target sum
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                int v = arr[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        dpPrint(dp);
        return dp[n][sum];
    }

    public static void dpPrint(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 7, 1, 3 };
        int sum = 10;
        System.out.println(tabular(arr, sum));
    }
}
