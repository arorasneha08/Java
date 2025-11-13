package Codeforces;

import java.util.Scanner;

public class A282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 

        int count = 0 ; 
        while(n-- > 0){
            String s = sc.next(); 
            if(s.equals("X++") || s.equals("++X")){
                count ++; 
            }
            else if(s.equals("X--") || s.equals("--X")){
                count -- ; 
            }
        }
        System.out.println(count);
        sc.close();
    }
}
