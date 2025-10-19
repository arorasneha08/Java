import java.util.ArrayList;
import java.util.Stack;

public class O6_MaxMinWindowSize {
    private int[] findnse(int arr[]){
        int n = arr.length; 
        Stack<Integer> st = new Stack<>(); 
        int nse[] = new int[n];
        for(int i = n-1; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop(); 
            }
            nse[i] = (st.isEmpty()) ? n : st.peek() ; 
            st.push(i); 
        }
        return nse ; 
    }
    private int[] findpse(int arr[]){
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>(); 
        int pse[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop(); 
            }
            pse[i] = st.isEmpty() ? -1 : st.peek(); 
            st.push(i); 
        }
        return pse; 
    }
    public ArrayList<Integer> maxOfMins(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = arr.length ; 
        int ans[] = new int[n+1];
        int nse[] = findnse(arr); 
        int pse[] = findpse(arr); 
        
        for(int i = 0 ; i < n ; i++){
            int windowSize = nse[i] - pse[i] - 1; 
            ans[windowSize] = Math.max(ans[windowSize] , arr[i]); 
        }
        for(int i = n-1; i>= 1 ; i--){
            ans[i] = Math.max(ans[i] , ans[i+1]); 
        }
        for(int i = 1 ; i < ans.length ; i++){
            res.add(ans[i]); 
        }
        return res; 
    }
}
