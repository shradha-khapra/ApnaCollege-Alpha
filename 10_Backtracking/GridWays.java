public class GridWays {
    public static int countGridWays(int i, int j, int n, int m) {
        if(i == n && j == m) {
            return 1;
        } else if(i > n || j > m) {
            return 0;
        }

        int ways = countGridWays(i+1, j, n, m) + countGridWays(i, j+1, n, m);
        return ways;
    }
    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println(countGridWays(0, 0, n-1, m-1));
    }
}
