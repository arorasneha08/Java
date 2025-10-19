package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class O41_PrintLIS {
    public ArrayList<Integer> getLIS(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = arr.length ; 
        int dp[] = new int[n]; 
        Arrays.fill(dp, 1); 
        int hash[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            hash[i] = i ; 
        }
        int max = Integer.MIN_VALUE;
        int lastIdx = 0 ; 
        for(int i = 0 ; i < n; i ++){
            for(int prev= 0 ; prev < i ; prev ++){
                if(arr[i] > arr[prev] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev]; 
                    hash[i] = prev;    
                }
            }
            if(dp[i] > max){
                max = dp[i]; 
                lastIdx = i ; 
            }
        }
        res.add(arr[lastIdx]); 
        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx] ;
            res.add(arr[lastIdx]); 
        }
        Collections.reverse(res); 
        return res ; 
    }
}
