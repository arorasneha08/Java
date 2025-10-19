package Math;

public class O2_ExcelSheetColNumber {
    public int titleToNumber(String str) {
        int n = str.length();
        if(n == 0) return 0;
        int res = 0 ; 

        for(int i = 0 ; i < n ; i++){
            char ch = str.charAt(i); 
            int num = ch - 'A' + 1; 
            res = res * 26 + num ; 
        }
        return res; 
    }
}
