package Arrays;

import java.util.ArrayList;
import java.util.List;

public class O5_ReversePairs {
    private int mergeSort(int left , int right , int arr[]){
        if(left >= right) return 0 ; 
        int count = 0 ; 
        int mid = left + (right - left)/2 ; 
        count += mergeSort(left , mid , arr); 
        count += mergeSort(mid + 1 , right , arr); 
        count += countPairs(left , mid , right , arr); 
        merge(left , mid , right , arr); 
        return count; 
    }
    private void merge(int low , int mid , int high , int arr[]){
        List<Integer> res = new ArrayList<>(); 
        int left = low ; 
        int right = mid + 1; 
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                res.add(arr[left]); 
                left ++; 
            }
            else{
                res.add(arr[right]); 
                right ++; 
            }
        }
        while(left <= mid){
            res.add(arr[left]); 
            left ++; 
        }
        while(right <= high){
            res.add(arr[right]); 
            right ++; 
        }
        for(int i = 0 ; i < res.size() ; i++){
            arr[i + low] = res.get(i); 
        }
    }
    private int countPairs(int low , int mid , int high , int arr[]){
        int right = mid + 1; 
        int count = 0 ; 
        
        for(int i = low ; i <= mid ; i++){
            while(right <= high && (long)arr[i] > 2L * arr[right]){
                right ++; 
            }
            count += (right - mid - 1); 
        }
        return count ; 
    }
    public int countRevPairs(int[] arr) {
        int n = arr.length ; 
        return mergeSort(0 , n-1 , arr); 
    }
}
