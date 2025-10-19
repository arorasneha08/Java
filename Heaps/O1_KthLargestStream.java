// package Heaps;

// import java.util.PriorityQueue;

// public class KthLargestStream {
//     PriorityQueue<Integer> pq ;
//     int k ; 

//     public KthLargest(int k, int[] nums) {
//         this.k = k ; 
//         pq =  new PriorityQueue<>(); 

//         for(int i = 0 ; i < nums.length ; i++){
//             if(pq.size() < k){
//                 pq.offer(nums[i]); 
//             }
//             else if(nums[i] > pq.peek()){
//                 pq.offer(nums[i]); 
//                 if(pq.size() > k){
//                     pq.poll(); 
//                 }
//             }
//         }
//     }
//     public int add(int val) {
//         if(pq.size() < k){
//             pq.offer(val); 
//         }
//         else if(val > pq.peek()){
//             pq.offer(val); 
//             pq.poll(); 
//         }
//         return pq.peek(); 
//     }
// }
