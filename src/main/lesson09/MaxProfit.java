package main.lesson09;
/*
 * check price values one by one. If new price is less than bought amount update it as a new bought amount.
 * If price of a stock is high than bought amount profit increases. 
 * Update maximum profit value if profit is higher from maximum profit so far.
 */
public class MaxProfit {
	public int solution(int[] A) {
        int maxProfit = 0;
        int buyAmount = Integer.MAX_VALUE;

        for(int i=0; i< A.length; i++){
            if(A[i] <= buyAmount){
                buyAmount = A[i];
            }else{
                maxProfit = Math.max(maxProfit, A[i] - buyAmount);
            }
        }

        return maxProfit;
    }
}
