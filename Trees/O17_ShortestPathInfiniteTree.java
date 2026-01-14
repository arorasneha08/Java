public class O17_ShortestPathInfiniteTree {
    public int distance(int x, int y) {
        int leftNode = x ; 
        int rightNode = y ; 
        int dist = 0  ;
        
        while(leftNode != rightNode){
            if(leftNode > rightNode){
                leftNode /= 2 ; 
            }
            else if(leftNode <= rightNode){
                rightNode /= 2 ; 
            }
            dist ++; 
        }
        return dist; 
    }
}