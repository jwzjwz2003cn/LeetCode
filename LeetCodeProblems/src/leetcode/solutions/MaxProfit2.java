package leetcode.solutions;

public class MaxProfit2 implements ISolution {

	public int maxProfit(int[] prices){
		
		if (prices.length == 0)
			return 0;
		
		int buy = prices[0];
		int profit = 0;
		
		for (int i = 0; i < prices.length; i++){
			
			buy = Math.min(prices[i], buy);
			profit = Math.max(profit, prices[i]-buy);
		}
		
		return profit;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		int[] prices ={123,142,156,146,144,123};
		int profit = maxProfit(prices);
		System.out.println(profit);
	}
	
	
}
