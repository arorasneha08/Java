package Strings; 

public class O14_MinAddParantheseValid {
    public int minParentheses(String s) {
        int n = s.length();
        int open = 0 ;
        int close = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open ++ ; 
            }
            else{
                if(open > 0){
                    open --; 
                }
                else close ++; 
            }
        }
        return open + close; 
    }
}
