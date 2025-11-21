import java.util.HashSet;

class O22_PalindromeLength3 {

    public int countPalindromicSubsequence(String s) {
        int n = s.length() ; 
        HashSet<Character> set = new HashSet();
        for(Character ch : s.toCharArray()){
            set.add(ch); 
        }
        int count = 0 ; 
        for(Character ch : set){
            int first = -1; 
            int last = -1; 
            for(int i = 0 ; i < n ; i++){
                if(s.charAt(i) == ch){
                    if(first == -1){
                        first = i ; 
                    }
                    last = i ; 
                }
            }
            HashSet<Character> unique = new HashSet<>(); 
            for(int i = first + 1; i < last ; i++){
                unique.add(s.charAt(i)); 
            }
            count += unique.size(); 
        }
        return count; 
    }
}

//leetcode 1930 