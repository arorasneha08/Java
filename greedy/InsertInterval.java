
import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length; 
        ArrayList<int[]> res = new ArrayList<>(); 
        Arrays.sort(intervals , (a, b) -> a[0] - b[0]); 
        int i = 0 ; 

        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]); 
            i++ ; 
        }
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0] , newInterval[0]); 
            newInterval[1] = Math.max(intervals[i][1] , newInterval[1]); 
            i++ ;
        }
        res.add(newInterval); 

        while(i < n){
            res.add(intervals[i]); 
            i++ ;
        }
        return res.toArray(new int[res.size()][]);  
    }
}
