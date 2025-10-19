package Strings ; 
import java.util.*;

public class O21_LexicographicallySmallestStringAfterKOperations {
    public String findLexSmallestString(String s, int a, int b) {
        String smallest = s ; 
        Queue<String> q = new LinkedList<>(); 
        Set<String> visited = new HashSet<>();
        q.offer(s);
        visited.add(s); 
        while(!q.isEmpty()){
            String curr = q.poll(); 
            if(curr.compareTo(smallest) < 0) {
                smallest = curr; 
            }
            StringBuilder str = new StringBuilder(curr); 
            for(int i = 1 ; i < str.length() ; i+= 2){
                str.setCharAt(i , (char) ((str.charAt(i) - '0' + a) % 10 + '0')); 
            }
            String newStr = str.toString();
            if(!visited.contains(newStr)){
                q.offer(newStr); 
                visited.add(newStr); 
            }
            String rotate = curr.substring(curr.length()- b) + curr.substring(0 , curr.length() - b); 
            if(!visited.contains(rotate)){
                q.offer(rotate); 
                visited.add(rotate);
            }
        }
        return smallest; 
    }
}
//leetcode 1625 