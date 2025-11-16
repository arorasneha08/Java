public class O10_FlattenLinkedList {
    class Node {
        int data;
        Node next;
        Node bottom;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }
    public Node merge(Node t1 , Node t2){
        Node d = new Node(-1); 
        Node temp = d; 
        if(t1 == null) return t2 ; 
        if(t2 == null) return t1; 
        while(t1 != null && t2 != null){
            if(t1.data < t2.data){
                temp.bottom = t1 ; 
                t1 = t1.bottom ; 
            }
            else{
                temp.bottom = t2 ; 
                t2 = t2.bottom; 
            }
            temp = temp.bottom ;
            temp.next = null; 
        }
        if(t1 != null){
            temp.bottom = t1 ; 
        }
        if(t2 != null){
            temp.bottom = t2 ; 
        } 
        return d.bottom ;
    }
    public Node flatten(Node head) {
        if(head == null || head.next == null) return head ;
        head.next = flatten(head.next);
        return merge(head , head.next); 
    }
}
