import java.util.ArrayList;
import java.util.List;

public class O8_CycleSort {
    private void cycleSort(int arr[]){
        for(int i = 0 ; i < arr.length ; i++){
            while(arr[i] != i + 1){
                int idx = arr[i] - 1; 
                if(arr[i] == arr[idx]) break; 
                int temp = arr[idx]; 
                arr[idx] = arr[i]; 
                arr[i] = temp; 
            }
        }
    }
    public List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> res = new ArrayList<>(); 
        cycleSort(arr); 
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != i+ 1){
                res.add(i+1); 
            }
        }
        return res; 
    }
}
