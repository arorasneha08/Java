import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O20_AccountsMerge {
    public class DSU{
        Map<String , String> parent = new HashMap<>();
        
        String find(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
            }
            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }
        void union(String a, String b){
            String pu = find(a); 
            String pv = find(b); 
            if(pu.equals(pv)) return ; 
            parent.put(pu, pv); 
        }
    }
    public ArrayList<ArrayList<String>> accMerge(String[][] arr) {
        DSU ds = new DSU(); 
        Map<String , String> emailToName = new HashMap<>(); 
        for(String row[] : arr){
            String name = row[0]; 
            String firstEmail = row[1]; 
           
            for(int i = 1 ; i < row.length; i++){
                String email = row[i]; 
                emailToName.put(email , name); 
                ds.union(firstEmail , email); 
            }
        }
        Map<String , List<String>> groups = new HashMap<>(); 
        for(String email : emailToName.keySet()){
            String root = ds.find(email); 
            groups.computeIfAbsent(root , k -> new ArrayList<>()).add(email); 
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>(); 
        for(String root : groups.keySet()){
            String name = emailToName.get(root); 
            List<String> emails = groups.get(root); 
            Collections.sort(emails); 
            
            ArrayList<String> list = new ArrayList<>();
            list.add(name); 
            list.addAll(emails); 
            res.add(list);
        }
        return res ; 
    }
}
