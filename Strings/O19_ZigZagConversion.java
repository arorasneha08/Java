package Strings;

import java.util.ArrayList;
import java.util.List;

public class O19_ZigZagConversion {
    public String convert(String s, int numRows) {
        int n = s.length(); 
        if(numRows == 1 || numRows >= n) return s; 
        List<List<Character>> res = new ArrayList<>(); 
        for(int i = 0 ; i < numRows ; i++){
            res.add(new ArrayList<>()); 
        }
        int idx = 0 ; 
        int d = 1 ; 
        for(char ch : s.toCharArray()){
            res.get(idx).add(ch) ; 
            if(idx == 0) d = 1 ; 
            else if(idx == numRows - 1) d = -1 ; 
            idx += d ; 
        }
        StringBuilder str = new StringBuilder(); 
        for(List<Character> list : res){
            for(char ch : list){
                str.append(ch); 
            }
        }
        return str.toString() ;
    } 
}
