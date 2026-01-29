import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class O12_WordLadder {
    private class Pair{
        String word ;
        int steps ; 
        Pair(String s , int step){
            word = s ;
            steps = step; 
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s) ; 
        }
        Queue<Pair> q = new LinkedList<>(); 
        q.offer(new Pair(beginWord , 1));
        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            String str = curr.word ; 
            int step = curr.steps ;

            if(str.equals(endWord)){
                return step ; 
            }

            for(int i = 0 ; i < str.length(); i++){
                for(char ch = 'a' ; ch <= 'z' ; ch ++){
                    char replaced[] = str.toCharArray(); 
                    replaced[i] = ch ; 
                    String replacedWord = new String(replaced); 
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord); 
                        q.offer(new Pair(replacedWord , step + 1)); 
                    }
                }
            }
        }
        return 0 ; 
    }
}
