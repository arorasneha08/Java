public class O5_MaxXorTwoNumbersArray {
    public class Node {
        Node links[] = new Node[2];
        boolean flag = false;

        Node() {
        }

        boolean containsKey(int bit) {
            if (links[bit] != null) {
                return true;
            }
            return false;
        }

        Node get(int bit) {
            return links[bit];
        }

        void put(int bit, Node node) {
            links[bit] = node;
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(int num) {
            Node temp = root;
            for(int i = 31 ; i>= 0; i--){
                int bit = (num >> i) & 1; 
                if(!temp.containsKey(bit)){
                    temp.put(bit , new Node()); 
                }
                temp = temp.get(bit); 
            }
            temp.setEnd();
        }

        private int getMaxXor(int num){
            Node temp = root; 
            int maxXor = 0 ; 
            for(int i = 31 ; i>= 0 ;  i--){
                int bit = (num >> i) & 1; 
                int opp = 1 - bit; 
                if(temp.containsKey(opp)){
                    maxXor |= (1 << i) ; 
                    temp = temp.get(opp); 
                }
                else{
                    temp = temp.get(bit); 
                }
            }
            return maxXor; 
        }
    }
    public int findMaximumXOR(int[] arr) {
        int n = arr.length; 
        Trie t = new Trie(); 
        for(int i = 0 ; i < n ; i++){
            t.insert(arr[i]); 
        }
        int maxXor = 0  ;
        for(int i = 0 ; i < n ; i++){
            maxXor = Math.max(maxXor , t.getMaxXor(arr[i])); 
        }
        return maxXor; 
    }
}
