package Codeforces;
import java.util.Scanner;
 
public class A1896 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt(); 
        while(t -- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n]; 
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt(); 
            }
            int min = Integer.MAX_VALUE; 
            for(int i = 0 ; i < n; i++){
                min = Math.min(min , arr[i]); 
            }
            if(arr[0] == min) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}