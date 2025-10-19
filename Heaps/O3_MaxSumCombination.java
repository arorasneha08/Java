import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class O3_MaxSumCombination {
    private class Pair implements Comparable<Pair>{
        int sum  , i , j ; 
        Pair(int sum , int i , int j){
            this.sum = sum ; 
            this.i = i ; 
            this.j = j ; 
        }
        public int compareTo(Pair other){
            return other.sum - this.sum;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = a.length ; 
        Arrays.sort(a); 
        Arrays.sort(b); 
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Set<String> visited = new HashSet<>(); 
        
        int i = n-1; 
        int j = n-1; 
        pq.offer(new Pair(a[i] + b[j] , i , j)); 
        
        while(k-- > 0 && !pq.isEmpty()){
            Pair curr = pq.poll(); 
            res.add(curr.sum); 
            i = curr.i ; 
            j = curr.j ; 
            if(i-1 >= 0 && !visited.contains((i-1) + "," + j)){
                pq.offer(new Pair(a[i-1] + b[j] , i-1 , j)); 
                visited.add((i-1) + "," + j); 
            }
            if(j-1 >= 0 && !visited.contains(i + "," + (j-1))){
                pq.offer(new Pair(a[i] + b[j-1] , i , j-1)); 
                visited.add((i) + "," + (j-1)); 
            }
        }
        return res; 
    }
}
