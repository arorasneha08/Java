
public class JumpGame {
    public boolean canJump(int[] arr) {
        int n = arr.length ;
        int max = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(i > max) return false; 
            max = Math.max(max , i + arr[i]); 
        }
        return true ; 
    }
}
