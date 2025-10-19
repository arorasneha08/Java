package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class O42_LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr); 
        List<Integer> res = new ArrayList<>(); 
        int n = arr.length ; 
        int dp[] = new int[n]; 
        int hash[] = new int[n]; 
        int max = Integer.MIN_VALUE; 
        int lastIdx = 0 ; 
        for(int i = 0  ; i < n ; i++){
            dp[i] = 1; 
            hash[i] = i ; 
        }
        for(int i  = 0 ; i < n; i ++){
            for(int prev = 0 ; prev < i ; prev ++){
                if(arr[i] % arr[prev] == 0 && 1 + dp[prev] > dp[i]){
                    hash[i] = prev; 
                    dp[i] = 1 + dp[prev]; 
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
        return res; 
    }
}
