import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O7_EventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length; 
        List<Integer> res = new ArrayList<>(); 
        List<Integer> topo = new ArrayList<>(); 
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>()); 
        } 

        int indegree[] = new int[n]; 
        Queue<Integer> q = new LinkedList<>(); 

        for(int i = 0 ; i < n ; i++){
            for(int adjNode: graph[i]){
                adj.get(adjNode).add(i); 
                indegree[i] ++; 
            }
        }

        for(int i = 0 ; i < n ; i ++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll(); 
            topo.add(curr); 
            for(int adjNode : adj.get(curr)){
                indegree[adjNode]--; 
                if(indegree[adjNode] == 0){
                    q.offer(adjNode); 
                }
            }
        }
        Collections.sort(topo); 
        return topo ;
    }
}
