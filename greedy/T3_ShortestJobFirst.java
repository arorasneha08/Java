import java.util.Arrays;

public class T3_ShortestJobFirst {
    static int solve(int arr[]) {
        Arrays.sort(arr); 
        int n = arr.length ; 
        int wait = 0 ;
        int time = 0 ; 
        for(int i = 0; i < n; i++){
            wait += time ; 
            time += arr[i]; 
        }
        return wait / n ; 
    }
}
