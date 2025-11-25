package Codeforces;

import java.util.Scanner;

public class A1829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while(t -- > 0){
            int n = sc.nextInt(); 
            int arr[] = new int[n]; 
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt(); 
            }
            int zeros = 0 ;
            int max = 0 ;
            for(int i = 0 ; i < n ; i++){
                if(arr[i] == 0){
                    zeros ++; 
                }
                else{
                    max = Math.max(max , zeros); 
                    zeros = 0 ; 
                }
            }
            max = Math.max(max , zeros); 
            System.out.println(max);
        }
    }
}
