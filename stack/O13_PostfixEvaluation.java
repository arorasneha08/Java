import java.util.Stack;

public class O13_PostfixEvaluation {
    public int evaluatePostfix(String[] arr) {
        int n = arr.length ; 
        Stack<Integer> st = new Stack<>();
        int res = 0 ; 
        
        for(int i = 0 ; i < n ; i++){
            int a = 0 ; 
            int b = 0 ; 
            if(arr[i].equals("+")){
                if(!st.isEmpty()) b = st.pop(); 
                if(!st.isEmpty()) a = st.pop(); 
                
                res = a + b; 
                st.push(res); 
            }
            else if(arr[i].equals("-")){
                if(!st.isEmpty()) b = st.pop(); 
                if(!st.isEmpty()) a = st.pop(); 
                
                res = a - b ; 
                st.push(res); 
            }
            else if(arr[i].equals("*")){
                if(!st.isEmpty()) b = st.pop(); 
                if(!st.isEmpty()) a = st.pop(); 
                res = a * b ; 
                st.push(res); 
            }
            else if(arr[i].equals("/")){
                if(!st.isEmpty()) b = st.pop(); 
                if(!st.isEmpty()) a = st.pop(); 
                res = (int) Math.floor((double)a / b) ; 
                st.push(res); 
            }
            else if(arr[i].equals("^")){
                if(!st.isEmpty()) b = st.pop(); 
                if(!st.isEmpty()) a = st.pop(); 
                
                res = (int) Math.pow(a , b); 
                st.push(res); 
            }
            else{
                int ch = Integer.parseInt(arr[i]); 
                st.push(ch); 
            }
        }
        return res ; 
    }
}
