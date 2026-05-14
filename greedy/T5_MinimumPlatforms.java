import java.util.Arrays;
import java.util.PriorityQueue;

public class T5_MinimumPlatforms {
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

    // another approach using priority queue
    public int minPlatform2(int arr[], int dep[]) {
        int n = arr.length ; 
        Arrays.sort(arr); 
        Arrays.sort(dep); 
        int platform = 0 ; 
        PriorityQueue<Integer> q = new PriorityQueue<>(); 
        
        for(int i = 0 ; i < n ; i++){
            if(!q.isEmpty() && arr[i] > q.peek()){
                while(!q.isEmpty() && arr[i] > q.peek()){
                    q.poll(); 
                }
                q.offer(dep[i]); 
            }
            else{
                q.offer(dep[i]) ;
                platform = Math.max(platform , q.size()) ;
            }
        }
        return platform; 
    }
}
