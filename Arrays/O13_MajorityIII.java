package Arrays;

import java.util.ArrayList;
import java.util.List;

public class O13_MajorityIII {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length; 
        List<Integer> res = new ArrayList<>();
        int count1 = 0 , count2 = 0 ;
        int elem1 = Integer.MIN_VALUE , elem2 = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++){
            if(count1 == 0 && arr[i] != elem2){
                elem1 = arr[i] ; 
                count1 = 1; 
            }
            else if(count2 == 0 && arr[i] != elem1){
                elem2 = arr[i];
                count2 = 1; 
            }
            else if(arr[i] == elem1){
                count1 ++; 
            }
            else if(arr[i] == elem2){
                count2 ++; 
            }
            else{
                count1 -- ;
                count2 -- ; 
            }
        }
        int min = n/3 ;
        count1 = 0 ; count2 = 0 ; 
        for(int i = 0 ; i< n ; i++){
            if(arr[i] == elem1) count1 ++; 
            if(arr[i] == elem2) count2 ++; 
        } 
        if(count1 > min) res.add(elem1); 
        if(count2 > min) res.add(elem2); 
        return res ;     
    }
}
