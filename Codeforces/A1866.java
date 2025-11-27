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
        int minNeg = Integer.MAX_VALUE ;
        int minPos = Integer.MAX_VALUE ; 
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > 0){
                minPos = Math.min(minPos , arr[i]); 
            }
            else{
                minNeg = Math.min(minNeg , arr[i]); 
            }
        }
        int abs1 = Math.abs(0 - minPos); 
        int abs2 = Math.abs(minPos - 0); 
        int ans = Math.min(abs1 , abs2); 
        System.out.println(ans); 
        sc.close();
    }
}
