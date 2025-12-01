import java.util.ArrayList;
import java.util.Stack;

public class O1_NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length; 
        Stack<Integer> st = new Stack<>(); 
        ArrayList<Integer> list = new ArrayList<>(); 
        int[] res = new int[n]; 
        
        st.push(arr[n - 1]); 
        res[n - 1] = -1; 
        
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop(); 
            }
            res[i] = st.isEmpty() ? -1 : st.peek(); 
            st.push(arr[i]); 
        }
        
        for (int i = 0; i < n; i++) {
            list.add(res[i]); 
        }
        
        return list; 
    }
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        int n = arr.length ; 
        ArrayList<Integer> res = new ArrayList<>(); 
        int ans[] = new int[n]; 
        Stack<Integer> st = new Stack<>(); 
        
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[i] <= st.peek()){
                st.pop();
            }
            ans[i] = (st.isEmpty()) ? -1 : st.peek(); 
            st.push(arr[i]); 
        }
        for(int i = 0 ; i< n ; i++){
            res.add(ans[i]); 
        }
        return res ; 
    }
}
