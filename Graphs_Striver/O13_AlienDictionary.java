import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O13_AlienDictionary {
    private List<Integer> topo(List<List<Integer>> adj , int n){
        List<Integer> top = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode] ++ ; 
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll(); 
            top.add(curr);
            
            for(int adjNode : adj.get(curr)){
                indegree[adjNode] --;
                if(indegree[adjNode] == 0){
                    q.offer(adjNode); 
                }
            }
        }
        return top ; 
    }
    public String findOrder(String[] words) {
        int n = words.length ; 
        List<List<Integer>> adj = new ArrayList<>(); 
        for(int i = 0 ; i < 26 ; i++){
            adj.add(new ArrayList<>()); 
        }
        boolean present[] = new boolean[26]; 
        for(String s : words){
            for(char ch : s.toCharArray()){
                present[ch - 'a'] = true; 
            }
        }
        for(int i = 0  ; i < n-1; i++){
            String word1 = words[i];
            String word2 = words[i+1]; 
            
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return ""; 
            }
            int len = Math.min(word1.length() , word2.length()); 
            for(int j = 0 ; j < len ; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) -'a'); 
                    break ; 
                }
            }
        }
        int k = 26 ; 
        List<Integer> list = topo(adj , k); 
        String res = "" ; 
        for(int i = 0 ; i < list.size() ; i++){
            if(present[list.get(i)]){
                res += (char)(list.get(i) + 'a'); 
            }
        }
        int count = 0 ; 
        for(int i = 0 ; i < 26 ; i ++){
            if(present[i]){
                count ++; 
            }
        }
        if(count == res.length()) return res; 
        return "" ; 
    }
}
