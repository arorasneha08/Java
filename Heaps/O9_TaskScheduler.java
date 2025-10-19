import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class O9_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length ;
        HashMap<Character , Integer> mpp = new HashMap<>(); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char ch : tasks){
            mpp.put(ch , mpp.getOrDefault(ch , 0) + 1); 
        }
        for(char key : mpp.keySet()){
            pq.offer(mpp.get(key)); 
        }
        int time = 0 ; 
        while(!pq.isEmpty()){
            int cycle = n + 1; 
            List<Integer> remaining = new ArrayList<>(); 

            while(cycle > 0 && !pq.isEmpty()){
                int freq = pq.poll() ;
                if(freq > 1){
                    remaining.add(freq-1); 
                }
                time ++ ;
                cycle -- ; 
            }

            for(int count : remaining){
                pq.offer(count); 
            }
            if(pq.isEmpty()) break ; 
            time += cycle; 
        }
        return time; 
    }
}
