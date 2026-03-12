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
    
    // gfg version  :- Note: A sequence of parentheses is balanced if every opening bracket has a corresponding closing bracket in the correct order.
// For example, "(())", "()()", and "(()())" are balanced, whereas ")()(", "))((", and "()))" are not.
    private void func(int open , int close , int n , List<String> res , String str){
        if(open + close == 2 * n){
            res.add(str); 
            return ; 
        }
        if(open < n){
            func(open + 1 , close , n , res ,str + '('); 
        }
        if(close < open){
            func(open , close + 1 , n, res, str + ')');
        }
    }
    public ArrayList<String> generateParentheses(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>(); 
        func(0 , 0 , n/2, res , ""); 
        return res ; 
    }
}
