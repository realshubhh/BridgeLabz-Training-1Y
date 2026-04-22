// LeetCode #121 - Best Time to Buy and Sell Stock
// Find the maximum profit from one buy/sell transaction.
// Time: O(n), Space: O(1)

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice  = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(sol.maxProfit(new int[]{7,6,4,3,1}));   // 0
        System.out.println(sol.maxProfit(new int[]{2,4,1}));       // 2
    }
}
