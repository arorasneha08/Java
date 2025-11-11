import java.util.Stack;

public class LongestValidParantheses {
    public int longestValidParentheses(String s) {
        int n = s.length(); 
        int left = 0 ; 
        int right = 0 ; 
        int max = 0 ; 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(ch == '(') left ++ ;
            else right ++ ; 

            if(left == right){
                max = Math.max(max , 2 * right); 
            }
            if(right > left){
                left = 0 ;
                right = 0 ; 
            }
        }
        left = 0 ;
        right = 0 ;
        for(int i = n-1 ; i >= 0 ; i--){
            char ch = s.charAt(i); 
            if(ch == '(') left ++ ;
            else right ++ ; 

            if(left == right){
                max = Math.max(max , 2 * left) ; 
            }
            if(left > right){
                left = 0 ;
                right = 0 ;
            }
        }
        return max ; 
    }
    public int longestValidParentheses2(String s) {
        int n = s.length(); 
        Stack<Integer> st = new Stack<>(); 
        st.push(-1) ;
        int maxLen = 0; 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(ch == '('){
                st.push(i);
            }
            else{
                st.pop(); 
                if(st.isEmpty()){
                    st.push(i); 
                }
                else{
                    int len = i -st.peek(); 
                    maxLen = Math.max(maxLen , len); 
                }
            }
        }
        return maxLen ; 
    }
}
