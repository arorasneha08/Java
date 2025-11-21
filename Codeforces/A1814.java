package Codeforces;

import java.util.Scanner;

public class A1814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while (t-- > 0) {
            long n = sc.nextLong();   // FIXED
            long k = sc.nextLong();   // FIXED
            
            if (n % 2 == 0 || (n - k) % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
