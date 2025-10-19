import java.util.Arrays;

public class O9_AggressiveCows {
    private static boolean isPossible(int mid , int arr[] , int k){
        int cows = 1; 
        int n = arr.length ; 
        int lastPlaced = arr[0]; 
        for(int i = 1 ; i < n ; i++){
            if(arr[i] - lastPlaced >= mid){
                cows ++; 
                lastPlaced = arr[i];
            }
            if(cows >= k) return true; 
        }
        return false; 
    }
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length ; 
        Arrays.sort(stalls);
        int start = 0 ;
        int end = stalls[n-1] - stalls[0];
        int res = -1; 
        
        while(start <= end){
            int mid = (start + end)/2; 
            if(isPossible(mid , stalls , k)){
                res = mid ;
                start = mid + 1 ;
            }
            else {
                end = mid - 1; 
            }
        }
        return res ; 
    }
}
