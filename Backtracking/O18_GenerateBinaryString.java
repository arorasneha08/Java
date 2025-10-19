package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class O18_GenerateBinaryString {
    private void func(int idx , int n , char bit[], StringBuilder str , List<String> list){
        if(idx == n){
            list.add(str.toString()); 
            return ; 
        }
        for(char ch : bit){
            str.append(ch); 
            func(idx + 1 , n, bit , str, list); 
            str.deleteCharAt(str.length()-1); 
        }
    }
    public ArrayList<String> binstr(int n) {
        ArrayList<String> list = new ArrayList<>(); 
        char bit[] = {'0' , '1'} ; 
        StringBuilder str = new StringBuilder(); 
        
        func(0 , n , bit , str, list); 
        return list; 
    }
}
