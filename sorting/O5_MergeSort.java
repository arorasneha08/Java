import java.util.ArrayList;
import java.util.List;

public class O5_MergeSort {
    void merge(int low , int mid , int high , int arr[]){
        int i = low ;
        int j = mid + 1; 
        List<Integer> temp = new ArrayList<>(); 
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]); 
                i++; 
            }
            else if(arr[i] > arr[j]){
                temp.add(arr[j]); 
                j++ ; 
            }
        }
        while(i <= mid){
            temp.add(arr[i]); 
            i++; 
        }
        while(j < high){
            temp.add(arr[j]);
            j++;
        }
        for(int k = 0 ; k < temp.size() ; k++){
            arr[low+k] = temp.get(k); 
        }
    }
    void mergeSort(int arr[], int l, int r) {
        if(l >= r) return ; 
        int mid = (l + r)/ 2 ; 
        mergeSort(arr , l, mid); 
        mergeSort(arr , mid + 1 , r);
        merge(l , mid , r , arr); 
    }
}
