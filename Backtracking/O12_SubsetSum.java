package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class O12_SubsetSum {
    private static void func(int idx , int sum , int arr[] , ArrayList<Integer> list){
        if(idx == arr.length){
            list.add(sum) ;
            return ; 
        }
        func(idx + 1 , sum + arr[idx] , arr , list); 
        func(idx + 1 , sum , arr , list); 
    }
    public static ArrayList<Integer> subsetSum(int arr[]) {
        int n = arr.length ;
        ArrayList<Integer> list = new ArrayList<>();  
        func(0 , 0 , arr , list); 
        Collections.sort(list); 
        return list; 
    }
}

