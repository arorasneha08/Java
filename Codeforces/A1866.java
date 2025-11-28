package Codeforces;

import java.util.Scanner;

public class A1866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt(); 
        int arr[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt() ;
        }
        int maxNeg = Integer.MIN_VALUE ;
        int minPos = Integer.MAX_VALUE ; 
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > 0){
                minPos = Math.min(minPos , arr[i]); 
            }
            else{
                maxNeg = Math.max(maxNeg , arr[i]); 
            }
        }
        int ans = Integer.MAX_VALUE ; 
        if(minPos != Integer.MAX_VALUE){
            ans = Math.min(ans , minPos); 
        }
        if(maxNeg != Integer.MIN_VALUE){
            ans = Math.min(ans , Math.abs(maxNeg));
        }
        System.out.println(ans); 
        sc.close();
    }
}
