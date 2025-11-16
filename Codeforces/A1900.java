package Codeforces;

import java.util.Scanner;

public class A1900 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        while(t-- > 0){
            int n = sc.nextInt(); 
            String s = sc.next(); 
            String chars[] = s.split("#"); 
            int op = 0 ; 
            boolean flag = false;
            for(int i = 0 ; i < chars.length ; i++){
                if(chars[i].length() >= 3){
                    flag = true; 
                    break ; 
                }
                else{
                    op += chars[i].length(); 
                }
            }
            if(flag){
                System.out.println(2);
            }
            else{
                System.out.println(op);
            }
        }
    }
}
