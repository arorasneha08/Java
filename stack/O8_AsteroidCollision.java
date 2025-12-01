import java.util.Stack;

public class O8_AsteroidCollision {
    public static int[] asteroidCollision(int n, int[] arr) {
       Stack<Integer> st = new Stack<>() ;
       for(int i = 0 ; i < n ; i++){
           if(arr[i] > 0){
               st.push(arr[i]); 
           }
           else{
               while(!st.isEmpty() && st.peek() > 0 && Math.abs(arr[i]) > st.peek()){
                   st.pop(); 
               }
               if(!st.isEmpty() && st.peek() == Math.abs(arr[i])){
                   st.pop(); 
               }
               else if(st.isEmpty() || st.peek() < 0){
                   st.push(arr[i]);
               }
           }
       }
       int res[] = new int[st.size()]; 
       int idx = st.size() - 1 ; 
       while(!st.isEmpty()){
           res[idx--] = st.pop(); 
       }
       return res; 
    }
}
