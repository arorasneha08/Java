public class O19_ReverseDLL {
    class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
    public Node reverse(Node head) {
        Node temp = head; 
        while(temp != null){
            Node prev = temp.prev ;
            temp.prev = temp.next;
            temp.next = prev ; 
            
            if(temp.prev == null) return temp ; 
            temp = temp.prev; 
        }
        return head; 
    }
}
