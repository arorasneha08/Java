package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class O10_GenerateParantheses {
    private void func(int open , int close , int n , String str , List<String> list){
        if(open == n && close == n){
            list.add(str); 
            return ; 
        }
        if(open < n){
            func(open + 1 , close , n , str + "(" , list); 
        }
        if(close < open){
            func(open , close + 1 , n , str + ")" , list); 
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>() ;
        String str = "" ; 
        func(0 , 0 , n , str , res); 
        return res; 
    }
}
