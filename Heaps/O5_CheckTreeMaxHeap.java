// public class O5_CheckTreeMaxHeap {
//     public class Node {
//         int data ; 
//         int left ; 
//         int right; 
//         Node(int data){
//             this.data =data  ; 
//         }
//     }
//     int count(Node root){
//         if(root == null) return 0;
        
//         return 1+count(root.left)+count(root.right);
//     }
    
//     boolean CBT(Node root,int index,int total_nodes){
//         if(root == null) return true;
//         if(index>=total_nodes) return false;
//         boolean left = CBT(root.left,2*index+1,total_nodes);
//         boolean right = CBT(root.right,2*index+2,total_nodes) ; 
        
//         return left && right;
//     }
//     boolean MaxHeap(Node root){
        
//         if(root.left!=null) {
//             if(root.data<root.left.data) return false;
//             if(MaxHeap(root.left)==false) return false;
//         }
//         if(root.right!=null) {
//             if(root.data<root.right.data) return false;
//             return MaxHeap(root.right);
//         }
//         return true;
//     }
    
//     boolean isHeap(Node tree) {
//         int num=count(tree);
//         boolean ans=CBT(tree,0,num);
//         if(ans==false) return false;
//         return MaxHeap(tree);
        
//     }
// }
