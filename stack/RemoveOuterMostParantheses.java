import java.util.Stack;

public class RemoveOuterMostParantheses {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int balance = 0 ;
        String res = "" ;

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(ch == '('){
                if(balance > 0){
                    res += ch ; 
                }
                balance ++; 
            }
            else{
                balance -- ; 
                if(balance > 0){
                    res += ch ; 
                }
            }
        }
        return res; 
    }
}
