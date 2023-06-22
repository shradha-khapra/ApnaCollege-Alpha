public class MinimumPartioning {
    public static int minPartioning(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];
        // bottom up
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j) { // valid
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else { // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 6, 11, 5 };
        System.out.println(minPartioning(nums));
    }
}
