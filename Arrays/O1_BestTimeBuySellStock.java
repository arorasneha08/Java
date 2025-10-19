package Arrays;

public class O1_BestTimeBuySellStock {
    public int maxProfit(int[] arr) {
        int n = arr.length ; 
        int buy = arr[0] ;
        int profit = 0 ; 
        for(int i = 0 ;  i< n ; i ++){
            int cost = arr[i] - buy ; 
            buy = Math.min(buy , arr[i]); 
            profit = Math.max(cost, profit) ; 
        }
        return profit;
    }
}

// 