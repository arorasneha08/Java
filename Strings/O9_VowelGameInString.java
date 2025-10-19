package Strings;

public class O9_VowelGameInString {
    public boolean doesAliceWin(String s) {
        int n = s.length(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i) ;
            if("aeiou".indexOf(ch) != -1){
                return true; 
            }
        }
        return false; 
    }
}
