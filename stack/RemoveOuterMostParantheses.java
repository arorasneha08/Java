public class RemoveOuterMostParantheses {
    public String removeOuterParentheses(String s) {
        int n = s.length(); 
        if(n <= 2) return ""; 
        char c[] = s.toCharArray(); 
        StringBuilder str = new StringBuilder(); 
        int open = 1 ; 

        for(int i = 1 ; i < n ; i++){
            if(c[i] == '('){
                open ++; 
                if(open > 1) str.append('('); 
            }
            else{
                if(open > 1) str.append(')'); 
                open --; 
            }
        }
        return str.toString(); 
    }
}
