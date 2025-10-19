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
    Node merge(Node a , Node b){
        Node d = new Node(-1); 
        Node temp = d ; 
        if(a == null) return b ; 
        if(b == null) return a; 
        while(a != null && b != null){
            if(a.data < b.data){
                temp.bottom = a ; 
                temp = a ; 
                a = a.bottom; 
            }
            else {
                temp.bottom = b ;
                temp = b ; 
                b = b.bottom ; 
            }
            temp.next = null; 
        }
        if(a != null){
            temp.bottom = a ;  
        }
        if(b != null){
            temp.bottom = b ; 
        }
        d.bottom.next = null ; 
        return d.bottom ; 
    }
    Node flatten(Node head) {
        if(head == null || head.next == null) return head;
        head.next = flatten(head.next); 
        return merge(head , head.next); 
    }
}
