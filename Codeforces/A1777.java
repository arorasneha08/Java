package Codeforces;

import java.util.Scanner;

public class A1777 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt(); 
        while(t-- > 0){
            int n = sc.nextInt() ;
            int arr[] = new int[n]; 
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt() ; 
            }
            int op = 0 ; 
            int seg = 0 ; 
            for(int i = 1 ; i < n ; i++){
                if(arr[i-1] % 2 != arr[i] % 2){
                    seg ++; 
                }
            }
            op = n - seg - 1;
            System.out.println(op); 
        }
    }
}
