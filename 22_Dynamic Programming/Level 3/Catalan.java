import java.util.Arrays;

public class Catalan {
    public static int catalanrec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0; // Cn
        for (int i = 0; i <= n; i++) {
            ans += catalanrec(i) * catalanrec(n - i - 1);
        }

        return ans;
    }

    public static int catalanMen(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0; // Cn
        for (int i = 0; i < n; i++) {
            ans += catalanMen(i, dp) * catalanMen(n - i - 1, dp);
        }

        return dp[n] = ans;
    }

    public static int catalanTab(int n) {
        int dp[] = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < 0; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // Ci = Cj * Ci-j-1
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(catalanrec(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(catalanMen(n, dp));

        System.out.println(catalanTab(n));
    }
}
