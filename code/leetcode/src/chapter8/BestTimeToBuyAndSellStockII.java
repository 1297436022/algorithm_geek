package chapter8;

class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        //贪心
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
