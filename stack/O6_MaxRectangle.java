import java.util.Stack;

public class O6_MaxRectangle {
    static int func(int arr[]){
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>();
        int maxArea = 0 ; 
        
        for(int i = 0  ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                int h = arr[st.pop()]; 
                int w = (st.isEmpty()) ? i : i - st.peek()-1; 
                int area = h * w ; 
                maxArea = Math.max(maxArea , area); 
            }
            st.push(i); 
        }
        while(!st.isEmpty()){
            int h = arr[st.pop()]; 
            int w = (st.isEmpty()) ? n : n - st.peek() - 1; 
            int area = h * w ; 
            maxArea = Math.max(maxArea , area); 
        }
        return maxArea ; 
    }
    static int maxArea(int mat[][]) {
        int n = mat.length ; 
        int m = mat[0].length ; 
        
        int pref[] = new int[m];
        int ans = 0 ; 
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    pref[j] = 0 ; 
                }  
                else{
                    pref[j] += 1 ; 
                }
            }
            ans = Math.max(ans , func(pref)); 
        }
        return ans ;
    }
}
