import java.util.ArrayList;
import java.util.Stack;

public class O11_StockSpanProblem {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(); 
        int ans[] = new int[n]; 
        Stack<Integer> st = new Stack<>(); 
        
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                st.pop(); 
            }
            ans[i] = (st.isEmpty()) ? i + 1 : i - st.peek(); 
            st.push(i); 
        }
        for(int i = 0 ; i < n ; i++){
            res.add(ans[i]); 
        }
        return res; 
    }
}
