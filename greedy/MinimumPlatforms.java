

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length ; 
        Arrays.sort(arr);
        Arrays.sort(dep); 
        int platforms = 1; 
        int res = 1; 
        int i = 1 ;
        int j = 0 ;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                platforms ++; 
                i++ ; 
            }
            else{
                platforms --; 
                j++; 
            }
            res = Math.max(res , platforms); 
        }
        return res; 
    }
}
