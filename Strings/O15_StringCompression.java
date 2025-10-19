package Strings;

public class O15_StringCompression {
    public int compress(char[] chars) {
        int n = chars.length ; 
        int idx = 0 ; 

        for(int i = 0 ; i < n ; i++){
            char ch = chars[i];
            int count = 0 ; 
            while(i < n && chars[i] == ch){
                count ++; 
                i++ ; 
            }
            i-- ; 
            chars[idx++] = ch ; 
            if(count > 1){
                String countStr = Integer.toString(count); 
                for(int j = 0 ; j < countStr.length() ; j++){
                    chars[idx++] = countStr.charAt(j); 
                }
            }
        }
        return idx ;
    }
}
