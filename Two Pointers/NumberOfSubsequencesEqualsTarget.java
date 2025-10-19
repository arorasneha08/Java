import java.util.Arrays;

public class NumberOfSubsequencesEqualsTarget {

// this code will give you the tle error as the Math.pow() will hold the value till the integer only 

    // public int numSubseq(int[] arr, int target) {
    //     int mod = (int) 1e9 + 7 ; 
    //     int n = arr.length ; 
    //     Arrays.sort(arr); 
    //     int left = 0 ;
    //     int right = n-1; 
    //     int count = 0 ; 
    //     while(left <= right){
    //         if(arr[left] + arr[right] <= target){
    //             count = (count + (int) Math.pow(2 , right - left) ) % mod; 
    //             left ++; 
    //         }
    //         else{
    //             right --; 
    //         }
    //     }
    //     return count; 
    // }


    // replace the pow with creating a new array where you precompute the powers of 2 in the code
    public int numSubseq(int[] arr, int target) {
        int mod = (int) 1e9 + 7 ; 
        int n = arr.length ; 
        Arrays.sort(arr); 
        int pow[] = new int[n]; 
        pow[0] = 1 ; 
        for(int i = 1 ; i < n ; i++){
            pow[i] = (pow[i-1] * 2) % mod; 
        }
        int left = 0 ;
        int right = n-1; 
        int count = 0 ; 
        while(left <= right){
            if(arr[left] + arr[right] <= target){
                count = (count + pow[right - left] ) % mod; 
                left ++; 
            }
            else{
                right --; 
            }
        }
        return count; 
    }
}
