package Strings ; 
import java.util.Stack;

public class O16_DecodeString {
    public String decodeString(String s) {
        int len = s.length(); 
        Stack<String> st = new Stack<>(); 
        Stack<Integer> numStack = new Stack<>(); 
        StringBuilder curr = new StringBuilder(); 
        int num = 0; 

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i); 

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); 
            } 
            else if (ch == '[') {
                numStack.push(num); 
                st.push(curr.toString()); 
                num = 0; 
                curr = new StringBuilder();  
            } 
            else if (ch == ']') {
                int n = numStack.pop(); 
                StringBuilder prev = new StringBuilder(st.pop()); 
                for (int j = 0; j < n; j++) {
                    prev.append(curr); 
                }
                curr = prev; 
            } 
            else {
                curr.append(ch); 
            }
        } 
        return curr.toString();
    }
}
