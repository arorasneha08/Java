package Arrays;

public class O20_HIndex {
    private int countVal(int mid , int arr[]){
        int count = 0 ; 
        for(int num : arr){
            if(num >= mid){
                count ++; 
            }
        }
        return count ; 
    }
    public int hIndex(int[] arr) {
        int n = arr.length ;
        int start = 0 ; 
        int end = n; 
        int res = 0 ;
        while(start <= end){
            int mid = (start) + (end - start)/2; 
            int count = countVal(mid , arr); 
            if(mid <= count){
                res = mid; 
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return res; 
    }
}
