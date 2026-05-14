import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class T2_LRUPageFaults {
    static int pageFaults(int n, int c , int pages[]) {
        int fault = 0 ; 
        Deque<Integer> q = new ArrayDeque<>(); 
        HashSet<Integer> set = new HashSet<>();  
        
        for(int i = 0 ; i < n ; i++){
            int page = pages[i]; 
            
            if(set.contains(page)){
                q.remove(page); 
                q.offerLast(page); 
            }
            else{
                fault ++; 
                if(q.size() == c){
                    int lru = q.pollFirst(); 
                    set.remove(lru); 
                } 
                q.offerLast(page); 
                set.add(page); 
            }
            
        }
        return fault ; 
    }
}
