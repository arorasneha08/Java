import java.util.ArrayList;
import java.util.Arrays;

public class T4_JobSequencingProblem {
    private class Pair{
        int deadline ;
        int profit; 
        
        Pair(int deadline , int profit){
            this.deadline = deadline; 
            this.profit = profit; 
        }
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        ArrayList<Integer> res = new ArrayList<>(); 
        int n = deadline.length;      
        
        int maxDeadline = 0 ; 
        Pair p[] = new Pair[n]; 
        for(int i = 0 ; i < n ; i++){
            p[i] = new Pair(deadline[i] , profit[i]); 
            maxDeadline = Math.max(maxDeadline , p[i].deadline); 
        }
        Arrays.sort(p , (a , b) -> b.profit - a.profit);
        int jobs = 0 ; 
        int gain = 0 ;
        int slot[] = new int[maxDeadline + 1]; 
        Arrays.fill(slot , -1); 
        
        for(int i = 0 ; i < n ; i++){
            for(int j = p[i].deadline - 1; j >= 0 ; j--){
                if(slot[j] == -1){
                    slot[j] = i ; 
                    jobs ++; 
                    gain += p[i].profit ; 
                    break ; 
                }
            }    
        }
        res.add(jobs);
        res.add(gain); 
        return res; 
    }
}
