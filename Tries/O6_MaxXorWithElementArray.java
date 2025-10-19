import java.util.Arrays;

public class O6_MaxXorWithElementArray {
    public class Node {
        Node links[] = new Node[26];
        boolean flag = false;

        Node() {
        }

        boolean containsKey(int index) {
            if (links[index] != null) {
                return true;
            }
            return false;
        }

        Node get(int index) {
            return links[index];
        }

        void put(int index, Node node) {
            links[index] = node;
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
            for(int i = 31 ;i >= 0 ; i--){
                int bit = (num >> i) & 1 ; 
                if(!temp.containsKey(bit)){
                    temp.put(bit , new Node()); 
                }
                temp = temp.get(bit); 
            }
            temp.setEnd();
        }

        private int getMax(int num){
            Node temp = root; 
            int maxXor = 0 ; 
            for(int i = 31 ; i>= 0 ;i--){
                int bit = (num >> i) & 1; 
                int opp = 1 - bit; 
                if(temp.containsKey(opp)){
                    maxXor = maxXor | (1 << i); 
                    temp = temp.get(opp); 
                }
                else{
                    temp = temp.get(bit);
                }
            }
            return maxXor; 
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int res[] = new int[queries.length]; 
        int n = nums.length ; 
        Trie t = new Trie(); 
        Arrays.sort(nums); 

        int queryWithIdx[][] = new int[queries.length][3]; 
        for(int i = 0 ; i < queries.length ;i++){
            queryWithIdx[i][0] = queries[i][0]; 
            queryWithIdx[i][1] = queries[i][1]; 
            queryWithIdx[i][2] = i;
        }
        Arrays.sort(queryWithIdx , (a ,b) -> Integer.compare(a[1] , b[1])); 
        int numsIdx = 0 ; 

        for(int i = 0 ; i< queryWithIdx.length; i++){
            int xi = queryWithIdx[i][0]; 
            int mi = queryWithIdx[i][1]; 
            int orgIdx = queryWithIdx[i][2]; 

            while(numsIdx < nums.length && nums[numsIdx] <= mi){
                t.insert(nums[numsIdx]); 
                numsIdx ++; 
            }

            if(numsIdx == 0 || nums[0] > mi){
                res[orgIdx] = -1; 
            }
            else{
                res[orgIdx] = t.getMax(xi); 
            }
        }
        return res ; 
    }
}
