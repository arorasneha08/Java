import java.util.Arrays;

public class O1_FreqMostFrequentElement {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr); 
        int n = arr.length ; 
        long res = 0 , total = 0 ; 
        int left = 0 ; 
        for(int i = 0 ; i< n ; i++){
            total += arr[i]; 
            // arr[i] * (i - left + 1) : target sum if all elements in the specific length become arr[i]
            while(arr[i] * (i - left + 1) - total > k ){
                total -= arr[left]; 
                left ++; 
            }
            res = Math.max(res, i - left + 1); 
        }
        return (int) res ;
    }
}
