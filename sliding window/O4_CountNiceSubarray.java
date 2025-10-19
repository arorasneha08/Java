public class O4_CountNiceSubarray {
    private int func(int arr[] , int k){
        int count = 0 ; 
        int left = 0 ; 
        int sum = 0 ; 
        for(int i = 0 ; i < arr.length ; i ++){
            sum += arr[i] % 2 ; 

            while(sum > k){
                sum -= arr[left] % 2; 
                left ++; 
            }
            count += (i - left + 1); 
        }
        return count; 
    }
    public int numberOfSubarrays(int[] arr, int k) {
        return func(arr , k) - func(arr , k-1); 
    }
}
