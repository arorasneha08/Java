import java.util.*;

public class O11_NearlySorted{
    public void nearlySorted(int[] arr, int k) {
        int n = arr.length ; 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0 ; 
        for(int num : arr){
            pq.offer(num); 
            if(pq.size() > k){
                arr[i] = pq.poll(); 
                i++ ;
            }
        }
        while(!pq.isEmpty()){
            arr[i] = pq.poll();
            i++; 
        }
        return ; 
    }
    public static void main(String[] args) {
        
    }
}