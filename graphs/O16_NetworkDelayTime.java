import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class O16_NetworkDelayTime {
    private class Pair implements Comparable<Pair>{
        int node ;
        int dist ; 

        Pair(int node , int dist){
            this.node = node ;
            this.dist = dist; 
        }
        public int compareTo(Pair other){
            return this.dist - other.dist; 
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int time[] : times){
            int u = time[0] - 1;
            int v = time[1] - 1; 
            int w = time[2]; 
            adj.get(u).add(new int[]{v , w}); 
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        int minTime[] = new int[n];
        Arrays.fill(minTime , Integer.MAX_VALUE); 
        minTime[k-1] = 0 ;
        pq.offer(new Pair(k-1 , 0)); 

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node; 
            int dist = curr.dist; 

            for(int[] neighbour : adj.get(currNode)){
                int adjNode = neighbour[0]; 
                int cost = neighbour[1]; 

                if(dist + cost < minTime[adjNode]){
                    minTime[adjNode] = dist + cost; 
                    pq.offer(new Pair(adjNode , minTime[adjNode])); 
                }
            }
        }
        int max = 0; 
        for(int time : minTime){
            if(time == Integer.MAX_VALUE){
                return -1; 
            }
            max = Math.max(max , time); 
        }
        return max; 
    }
}
