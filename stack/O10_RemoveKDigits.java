import java.util.Stack;

public class O10_RemoveKDigits {
    public String removeKdig(String s, int k) {
        int n = s.length(); 
        Stack<Integer> st = new Stack<>(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            
            while(!st.isEmpty() && st.peek() > (ch - '0') && k > 0){
                st.pop();
                k--;
            }
            st.push(ch - '0'); 
        }   
        while(!st.isEmpty() && k > 0){
            st.pop(); 
            k-- ; 
        }
        StringBuilder str = new StringBuilder(); 
        while(!st.isEmpty()){
            str.append((char)('0' + st.pop())); 
        }
        str = str.reverse(); 
        if(str.length() == 0) return "0"; 
        while(str.length() > 0 && str.charAt(0) == '0'){
            str.deleteCharAt(0); 
        }
        if(str.isEmpty()) return  "0"; 
        return str.toString(); 
    }
}
