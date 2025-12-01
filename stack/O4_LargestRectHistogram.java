import java.util.Stack;

public class O4_LargestRectHistogram {
    public static int getMaxArea(int arr[]) {
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>(); 
        int maxArea = 0 ; 
        
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int h = arr[st.pop()]; 
                int w = (st.isEmpty()) ? i : i - st.peek() -1 ;
                int area = h * w ; 
                maxArea = Math.max(maxArea , area); 
            }    
            st.push(i); 
        }
        while(!st.isEmpty()){
            int h = arr[st.pop()]; 
            int w = st.isEmpty() ? n : n - st.peek()-1; 
            int area = h * w;  
            maxArea = Math.max(maxArea , area); 
        }
        return maxArea; 
    }
}
