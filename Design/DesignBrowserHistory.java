import java.util.HashMap;

public class DesignBrowserHistory {
    class BrowserHistory {
    class Node{
        String data ;
        Node prev ; 
        Node next ; 
        
        Node(String data){
            this.data = data ;
            this.prev = null;
            this.next = null ;
        }
    }
    
    HashMap<Integer , Node> mpp ; 
    Node curr ;
    int idx ; 
    int maxIdx ;
    
    BrowserHistory(String homepage) {
        mpp = new HashMap<>(); 
        curr = new Node(homepage); 
        idx = 0 ;
        maxIdx = 0 ;
        mpp.put(idx , curr); 
    }

    void visit(String url) {
        Node node = new Node(url); 
        curr.next = node ;
        node.prev = curr ;
        curr = node ; 
        
        idx ++ ; 
        maxIdx = idx ; 
        mpp.put(idx , curr); 
    }

    String back(int steps) {
        idx = Math.max(0 , idx - steps);
        curr = mpp.get(idx); 
        return curr.data ; 
    }

    String forward(int steps) {
        idx = Math.min(maxIdx , idx + steps) ;
        curr = mpp.get(idx);
        return curr.data ; 
    }
}
}
