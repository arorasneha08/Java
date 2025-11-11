package Strings;

import java.util.Stack;

public class O1_ValidParanthesisString {
    public boolean checkValidString(String s) {
        int n = s.length(); 
        Stack<Integer> st = new Stack<>(); 
        Stack<Integer> star = new Stack<>(); 
        for(int i = 0 ; i < n ; i ++){
            char ch = s.charAt(i); 
            if(ch == '('){
                st.push(i); 
            }
            else if(ch == '*'){
                star.push(i); 
            }
            else if(ch == ')'){
                if(!st.isEmpty()){
                    st.pop(); 
                }
                else if(!star.isEmpty()){
                    star.pop(); 
                }
                else{
                    return false; 
                }
            }
        }
        while(!st.isEmpty() && !star.isEmpty()){
            if(st.peek() > star.peek()){
                return false; 
            }
            st.pop();
            star.pop(); 
        }
        if(!st.isEmpty()) return false; 
        return true ; 
    }
    // using recursion 
    public boolean isBalanced(String s) {
        if(s.isEmpty()) return true ; 
        if(s.length() % 2 != 0) return false ; 
        
        char open = s.charAt(0); 
        char close ;
        if(open == '(') close = ')'; 
        else if(open == '[') close = ']'; 
        else if(open == '{') close = '}'; 
        else return false; 
        
        int balance = 0 ; 
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == open){
                balance ++; 
            }
            else if(ch == close){
                balance -- ; 
            }
            if(balance == 0){
                return isBalanced(s.substring(1 , i)) && (isBalanced(s.substring(i + 1)));
            }
        }
        return false; 
    }
}
