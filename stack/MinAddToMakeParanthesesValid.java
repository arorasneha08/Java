import java.util.Stack;

public class MinAddToMakeParanthesesValid {
    public int minAddToMakeValid(String s) {
        int n = s.length(); 
        Stack<Character> st = new Stack<>(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(ch == '('){
                st.push(ch); 
            }
            else if(ch == ')'){
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop(); 
                }
                else{
                    st.push(ch); 
                }
            }
        }
        return st.size(); 
    }
}
