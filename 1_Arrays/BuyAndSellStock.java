package Arrays;
/* 
    DSA Sheet No. 19
    Topic - Arrays
    Level - Medium
*/
public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profitToday = prices[i] - buyPrice;
                profit = Math.max(profitToday, profit);
            }
            else {
                buyPrice = prices[i];
            }
        }

        return profit;
    }
    public static void main(String args[]) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
