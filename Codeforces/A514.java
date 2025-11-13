package Codeforces;

import java.util.Scanner;

public class A514 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); 
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            int flipped = 9 - digit;

            if (i == 0 && digit == 9) {
                ans.append(9);
            } else {
                ans.append(Math.min(digit, flipped));
            }
        }

        System.out.println(ans.toString());
        sc.close();
    }
}
