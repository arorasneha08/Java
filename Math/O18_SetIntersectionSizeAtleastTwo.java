import java.util.Arrays;

public class O18_SetIntersectionSizeAtleastTwo{
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length ;
        int last1 = -1;
        int last2 = -1; 
        Arrays.sort(intervals , (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]); 
        int res = 0 ;
        
        for(int i = 0 ; i < n ; i ++){
            int start = intervals[i][0];
            int end = intervals[i][1]; 
            boolean l1 = (last1 >= start && last1 <= end); 
            boolean l2 = (last2 >= start && last2 <= end); 

            if(l1 && l2){
                continue; 
            }
            else if(l1 || l2){
                res ++; 
                int newEnd = end; 
                if(last1 > last2){
                    last2 = newEnd; 
                }
                else if(last1 < last2){
                    last1 = newEnd; 
                }
            }
            else{
                res += 2 ; 
                last1 = end - 1; 
                last2 = end; 
            }
            if(last1 > last2){
                int temp = last1 ; 
                last1 = last2 ;
                last2 = temp; 
            }
        }
        return res; 
    }
}

// leetcode 757 