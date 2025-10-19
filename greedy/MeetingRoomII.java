
import java.util.Arrays;

public class MeetingRoomII {
    public int minMeetingRooms(int[] start, int[] end) {
        int n = start.length ; 
        Arrays.sort(start); 
        Arrays.sort(end); 
        int i = 1 ; 
        int j = 0 ; 
        int count = 1 ; 
        int max = 1 ; 
        while(i < n && j < n){
            if(start[i] < end[j]){
                count ++ ; 
                i ++; 
            }
            else{
                count -- ; 
                j ++ ; 
            }
            max = Math.max(max , count); 
        }
        return max ; 
    }
}
