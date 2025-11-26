package Codeforces;

import java.util.Scanner;

public class A1877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt(); 
        while(t-- > 0){
            int n = sc.nextInt(); 
            int arr[] = new int[n]; 
            for(int i = 0; i < n-1; i++){
                arr[i] = sc.nextInt(); 
            }
            int sum = 0 ; 
            for(int i = 0 ; i< n ; i++){
                sum += arr[i]; 
            }
            System.out.println(-sum);
        }
        sc.close();
    }
}
