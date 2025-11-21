
public class O15_NumberOfLaserBeams {
    private int countOnes(String str){
        int count = 0 ;
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == '1'){
                count ++ ; 
            }
        }
        return count ; 
    }
    public int numberOfBeams(String[] bank) {
        int n = bank.length ; 
        int beams = 0 ; 
        int prev = 0 ; 
        for(int i = 0 ; i < n; i++){
            String str = bank[i]; 
            int cnt = countOnes(str); 
            if(cnt > 0){
                beams += (prev * cnt); 
                prev = cnt; 
            }
        }
        return beams ; 
    }
}

// leetcode 2125 