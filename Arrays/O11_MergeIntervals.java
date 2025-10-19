package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O11_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length ; 
        List<int[]> res = new ArrayList<>();  
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0] , b[0])); 
        for(int i = 0 ; i < n ; i++){
            if(res.isEmpty() || intervals[i][0] > res.get(res.size()-1)[1]){
                res.add(intervals[i]); 
            }
            else{
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1] , intervals[i][1]); 
            }
        }
        return res.toArray(new int[res.size()][]); 
    }
}
