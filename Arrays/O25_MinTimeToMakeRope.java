package Arrays;

public class O25_MinTimeToMakeRope {
    public int minCost(String colors, int[] time) {
        int n = colors.length();  
        int min = 0 ; 
        for(int i = 1 ; i < n ; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                min += Math.min(time[i] , time[i-1]); 
                time[i] = Math.max(time[i] , time[i-1]); 
            }
        }
        return min ; 
    }
}

// leetcode 1578 