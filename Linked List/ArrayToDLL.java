// public class ArrayToDLL {
//     class Solution {
//         Node constructDLL(int arr[]) {
//             if(arr.length == 0 || arr == null){
//                 return null ; 
//             }
//             Node head = new Node(arr[0]);
//             Node temp = head;
//             for(int i = 1; i< arr.length ; i++){
//                 Node newNode = new Node(arr[i]); 
//                 temp.next = newNode ; 
//                 newNode.prev = temp; 
//                 temp = newNode ; 
//             }
//             return head; 
//         }
//     }
// }
