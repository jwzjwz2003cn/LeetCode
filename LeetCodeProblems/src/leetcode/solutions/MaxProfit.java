package leetcode.solutions;

public class MaxProfit {
	
	public int maxProfit(int[] prices)
	{
		boolean isBought = false;
		int profit = 0;
		for (int i = 0; i < prices.length-1; i++)
		{
			if (prices[i+1] > prices[i])
			{
				if (!isBought)
				{
					isBought = true;
				}
				profit += prices[i+1]-prices[i];
			}
			else
			{
				if (isBought)
				{
					isBought = false;
				}
			}
		}
		return profit;
	}

}
