package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class O26_SpecialBinaryString {
    public String makeLargestSpecial(String s) {
        int n = s.length(); 
        List<String> res = new ArrayList<>(); 
        int count = 0 ;
        int start = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '1') count ++ ;
            else count -- ;

            if(count == 0){
                String inner = makeLargestSpecial(s.substring(start + 1 , i)); 
                res.add("1" + inner + "0"); 
                start = i + 1; 
            }
        }
        Collections.sort(res , Collections.reverseOrder()); 
        StringBuilder sb = new StringBuilder(); 
        for(String str : res){
            sb.append(str); 
        }
        return sb.toString(); 
    }
}
