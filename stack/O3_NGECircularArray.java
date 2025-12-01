import java.util.ArrayList;
import java.util.Stack;

public class O3_NGECircularArray {
    public ArrayList<Integer> nextGreater(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>(); 
        int ans[] = new int[n]; 
        
        for(int i = 2 * n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i % n]){
                st.pop(); 
            }
            ans[i % n] = (st.isEmpty()) ? -1 : arr[st.peek()]; 
            st.push(i % n); 
        }
        for(int i = 0 ; i < n ; i++){
            res.add(ans[i]); 
        }
        return res; 
    }
}
