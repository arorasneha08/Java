public class O9_KMP {
    void computeLPSArray(String pat, int M, int lps[]) {
        lps[0] = 0 ; 
        int len = 0 ; 
        int i = 1; 
        while(i < M){
            if(pat.charAt(i) == pat.charAt(len)){
                len ++;
                lps[i] = len ; 
                i++; 
            }
            else{
                if(len != 0){
                    len = lps[len - 1]; 
                }
                else{
                    lps[i] = 0 ;
                    i++ ;
                }
            }
        }
    }

    // Function to check if the pattern exists in the string or not.
    boolean KMPSearch(String pat, String txt) {
        int i = 0 ;
        int j = 0 ; 
        int n = pat.length() ; 
        int m = txt.length(); 
        int lps[] = new int[n];
        
        computeLPSArray(pat , n , lps); 
        
        while(i < m){
            if(txt.charAt(i) == pat.charAt(j)){
                i ++; 
                j ++; 
                
                if(j == n){
                    return true; 
                }
            }
            else{
                if(j != 0){
                    j = lps[j-1]; 
                }
                else{
                    i++; 
                }
            }
        }
        return false ; 
    }
}