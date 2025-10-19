package Arrays;

import java.util.ArrayList;
import java.util.List;

public class O16_CountInversions {
    private static int merge(int arr[] , int low , int mid , int high){
        List<Integer> list = new ArrayList<>(); 
        int left = low ; 
        int right = mid + 1; 
        int count = 0;  
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                list.add(arr[left]); 
                left ++; 
            }
            else {
                list.add(arr[right]); 
                count += (mid - left + 1); 
                right ++; 
            }
        }
        while(left <= mid){
            list.add(arr[left]); 
            left ++; 
        }
        while(right <= high){
            list.add(arr[right]); 
            right ++; 
        }
        for(int i = low ; i <= high ; i++){
            arr[i] = list.get(i - low);
        }
        return count; 
    }
    private static int mergeSort(int arr[] , int low , int high){
        if(low >= high) return 0; 
        int mid = (low + high) / 2; 
        int count = 0 ; 
        count += mergeSort(arr, low , mid); 
        count += mergeSort(arr, mid + 1 , high); 
        count += merge(arr , low , mid , high); 
        return count; 
    }
    static int inversionCount(int arr[]) {
        int n = arr.length ; 
        return mergeSort(arr , 0 , n-1); 
    }
}
