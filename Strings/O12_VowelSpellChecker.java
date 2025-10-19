package Strings ; 
import java.util.* ; 

public class O12_VowelSpellChecker {
    private String convertToNoVowel(String str){
        char ch[] = str.toCharArray() ;
        for(int i = 0 ; i < ch.length ; i++){
            if("aeiouAEIOU".indexOf(ch[i]) != -1 ){
                ch[i] = '*'  ; 
            }
        }
        return new String(ch);
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>(Arrays.asList(wordlist)); 
        String res[] = new String[queries.length]; 
        HashMap<String , String> lowerMap = new HashMap<>(); 
        HashMap<String , String> errorMap = new HashMap<>() ; 

        for(String word : wordlist){
            String low = word.toLowerCase(); 
            String noVowel = convertToNoVowel(low); 
            if(!lowerMap.containsKey(low)){
                lowerMap.put(low , word); 
            }
            if(!errorMap.containsKey(noVowel)){
                errorMap.put(noVowel , word); 
            }
        }
        for(int i = 0 ; i < queries.length ; i++){
            String s = queries[i]; 
            if(set.contains(s)){
                res[i] = s; 
            }
            else{
                String low = s.toLowerCase() ;
                String noVowel = convertToNoVowel(low); 
                if(lowerMap.containsKey(low)){
                    res[i] = lowerMap.get(low); 
                }
                else if(errorMap.containsKey(noVowel)){
                    res[i] = errorMap.get(noVowel); 
                }
                else{
                    res[i] = "" ; 
                }
            }
        }
        return res; 
    }
}