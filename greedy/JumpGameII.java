
public class JumpGameII {
    public int jump(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        
        int jumps = 0, currentEnd = 0, farthest = 0;
        
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);
            
            if (i == currentEnd) { 
                jumps++;
                currentEnd = farthest;
                if (currentEnd >= n - 1) break;
            }
        }
        return jumps;
    }
}
