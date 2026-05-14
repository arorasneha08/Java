import java.util.Arrays;

public class T6_Candy {
    public int candy(int[] arr) {
        int n = arr.length ; 
        int candies[] = new int[n]; 
        Arrays.fill(candies , 1); 

        for(int i = 1 ; i < n ; i++){
            if(arr[i] > arr[i-1]){
                candies[i] = candies[i-1] + 1; 
            }
        }
        int count = 0 ; 
        for(int i = n - 1 ; i > 0 ; i--){
            if(arr[i-1] > arr[i]){
                candies[i-1] = Math.max(candies[i-1], candies[i] + 1);
            }
        }
        for(int i = 0 ; i < n ; i++){
            count += candies[i]; 
        }
        return count; 
    }
}
