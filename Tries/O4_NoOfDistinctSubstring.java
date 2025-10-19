public class O4_NoOfDistinctSubstring {
    public static class Node {
        Node links[] = new Node[26]; 
        boolean flag = false ; 
        Node() {} 
        
        boolean containsKey(char ch){
            return (links[ch - 'a'] != null); 
        }
        void put(char ch , Node node){
            links[ch - 'a'] = node;
        }
        Node get(char ch){
            return links[ch - 'a']; 
        }
        boolean isEnd(){
            return flag ; 
        }
        void setEnd(){
            flag = true; 
        }
        
    }
    public static class Trie {
        Node root ; 
        
        int count = 0 ;  
        Trie(){
            root = new Node(); 
        }
        void insert(String word){
            Node temp = root;
            int n = word.length(); 
            for(int i = 0 ; i < n ; i++){
                char ch = word.charAt(i); 
                if(!temp.containsKey(ch)){
                    temp.put(ch , new Node());
                    count ++; 
                }
                temp = temp.get(ch); 
            }   
            temp.setEnd(); 
        }   
        int getCount(){
            return count; 
        }
    }
    public static int distinctSubstring(String word) {
        int n = word.length(); 
        Trie t = new Trie(); 
        for(int i = 0 ; i< n ; i++){
            t.insert(word.substring(i)); 
        }
        return t.getCount(); 
    }
}
