
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingsInRoom {
    private class Pair implements Comparable<Pair>{
        int start ;
        int end ; 
        Pair(int start , int end){
            this.start = start ; 
            this.end = end; 
        }
        public int compareTo(Pair other){
            return this.end - other.end ; 
        }
    }
    public int maxMeetings(int start[], int end[]) {
        int n = start.length; 
        List<Pair> list = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){
            list.add(new Pair(start[i] , end[i])); 
        }
        Collections.sort(list); 
        int lastEnd = -1 ;
        int count = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(list.get(i).start > lastEnd){
                lastEnd = list.get(i).end ;  
                count ++; 
            }
        }
        return count ; 
    }
}
