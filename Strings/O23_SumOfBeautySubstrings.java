package Strings;

import java.util.HashMap;

public class O23_SumOfBeautySubstrings {
    public int beautySum(String s) {
        int n = s.length(); 
        int sum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            HashMap<Character , Integer> mpp = new HashMap<>(); 
            int maxFreq = Integer.MIN_VALUE ;
            
            for(int j = i ; j < n ;j++){
                int minFreq = Integer.MAX_VALUE ;
                mpp.put(s.charAt(j) , mpp.getOrDefault(s.charAt(j) , 0) + 1); 
                maxFreq = Math.max(maxFreq , mpp.get(s.charAt(j))); 
                for(char key : mpp.keySet()){
                    minFreq = Math.min(minFreq , mpp.get(key)); 
                }
                sum += (maxFreq - minFreq); 
            }
        }
        return sum ; 
    }
}
