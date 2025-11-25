package Codeforces;

import java.util.Scanner;

public class A1878 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt(); 
        while(t-- > 0){
            int n = sc.nextInt(); 
            int k = sc.nextInt(); 
            int arr[] = new int[n]; 
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt(); 
            }
            boolean flag = false ; 
            for(int i = 0 ; i < n ; i++){
                if(arr[i] == k){
                    flag = true; 
                    break ; 
                }
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
