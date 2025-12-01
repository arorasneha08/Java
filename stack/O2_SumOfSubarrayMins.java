import java.util.Stack;

public class O2_SumOfSubarrayMins {
    public int[] nse(int arr[]){
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>(); 
        int res[] = new int[n]; 
        for(int i = n-1;  i>= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop(); 
            }
            res[i] = (st.isEmpty()) ? n : st.peek(); 
            st.push(i);
        }
        return res; 
    }
    public int[] pse(int arr[]){
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>(); 
        int res[] = new int[n]; 
        for(int i = 0 ;  i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop(); 
            }
            res[i] = (st.isEmpty()) ? -1 : st.peek(); 
            st.push(i);
        }
        return res; 
    }
    public int sumSubMins(int[] arr) {
        int mod = (int) 1e9+ 7 ; 
        int n = arr.length; 
        int nse[] = nse(arr); 
        int pse[] = pse(arr); 
        long total =  0 ;
        for(int i = 0 ; i < n ; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + (left * right % mod) * arr[i]) % mod;
        }
        return (int)total ; 
    }
}
