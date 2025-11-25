package Codeforces;

import java.util.Scanner;

public class A1791 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt() ; 
        while(t -- > 0){
            int n = sc.nextInt(); 
            String s = sc.next(); 
            char ch[] = s.toCharArray(); 
            int left = 0 ; 
            int right = n-1;
            while(left < right){
                if((ch[left] == '0' && ch[right] == '1') || (ch[left] == '1' && ch[right] == '0')){
                    left ++; 
                    right --; 
                }
                else{
                    break ;
                }
            }
            System.out.println(right - left + 1);
        }
    }
}