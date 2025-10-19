package Arrays;

public class O3_RearrangePosNeg {
    public int[] rearrangeArray(int[] arr) {
        int n = arr.length ; 
        int res[] = new int[n]; 
        int pos  = 0 , neg = 1 ; 
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > 0){
                res[pos] = arr[i];
                pos += 2;   
            }
            else if(arr[i] < 0){
                res[neg] = arr[i];  
                neg += 2;  
            }
        }
        return res ;
    }
}

// leetcode 2149 