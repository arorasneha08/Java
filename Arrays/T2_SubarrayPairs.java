package Arrays;

import java.util.Arrays;

public class T2_SubarrayPairs {
    int countPairs(int[] arr) {
        int n = arr.length ; 
        int count = 0 ; 
        int left = 0 , right = 0; 
        boolean visited[] = new boolean[n]; 
        Arrays.fill(visited , false); 
        
        while(right < n){
            while(right < n && !visited[arr[right]]){
                visited[arr[right]] = true; 
                count += (right - left);
                right ++; 
            }
            while(left < right && right != n && visited[arr[right]]){
                visited[arr[left]] = false ; 
                left ++; 
            }
        }
        return count ; 
    }
}
