package Codeforces;

import java.util.Scanner;

public class A1881 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt();  
        while(t-- > 0){
            int n = sc.nextInt(); 
            int m = sc.nextInt() ; 
            String x = sc.next(); 
            String s = sc.next(); 

            int op = 0 ; 
            boolean found = false; 
            for(int i = 0 ; i < 10 ; i++){
                if(x.contains(s)){
                    found = true ; 
                    break; 
                }
                x += x ; 
                op ++ ; 
            }
            if(found){
                System.out.println(op);
            }
            else{
                System.out.println(-1);
            }
        }
        sc.close();
    }
}
