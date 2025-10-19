package Arrays;

public class O2_SortColors {
    public void sortColors(int[] arr) {
        int low = 0 ;
        int n = arr.length ; 
        int high = n-1; 
        int mid = 0 ; 
        while(mid <= high){
            if(arr[mid] == 0){
                int temp = arr[mid] ; 
                arr[mid] = arr[low] ; 
                arr[low] = temp ; 
                low ++ ;
                mid ++; 
            }
            else if(arr[mid] == 1){
                mid ++; 
            }
            else{
                int temp = arr[mid] ; 
                arr[mid] = arr[high]; 
                arr[high] = temp ; 
                high -- ; 
            }
        }
    }
}

// leetcode 75 