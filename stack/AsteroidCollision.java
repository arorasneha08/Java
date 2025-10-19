import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length; 
        Stack<Integer> st = new Stack<>(); 

        for(int i = 0 ; i < n ; i++){
            if(arr[i] > 0){
                st.push(arr[i]); 
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(st.peek()) < Math.abs(arr[i])){
                    st.pop(); 
                }
                if(st.isEmpty() || st.peek() < 0) st.push(arr[i]); 
                else if(!st.isEmpty() & st.peek() == Math.abs(arr[i])){
                    st.pop(); 
                }
            } 
        }
        int res[] = new int[st.size()]; 
        for(int i = st.size()-1 ; i >= 0 ; i--){
            res[i] = st.pop(); 
        }
        return res; 
    }
}
