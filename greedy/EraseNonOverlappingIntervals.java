import java.util.Arrays;

public class EraseNonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a, b) -> a[1] - b[1]); 
        int count = 0 ; 
        int end = intervals[0][1]; 
        for(int interval[] : intervals){
            if(interval[0] < end){
                count ++ ; 
            }
            else {
                end = interval[1]; 
            }
        }
        return count -1; 
    }
}
