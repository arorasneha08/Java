package Math ; 

public class O7_VowelAllSubstring {
    private boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) != -1  ;
    }
    public long countVowels(String word) {
        int n = word.length();
        long count =  0 ; 
        for(int i = 0 ; i <  n ; i++){
            if(isVowel(word.charAt(i))){
                count += (long)(i + 1) * (n - i); 
            }
        }
        return count; 
    }
}

// leetcode 2063 