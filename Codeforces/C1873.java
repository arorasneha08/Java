package Codeforces;

import java.util.Scanner;

public class C1873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt() ;
        int score[][] = {
            {1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            {2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 },
            {3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 },
            {4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 },
            {5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
            {4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 },
            {3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 },
            {2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 },
            {1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
        }; 
        while(t-- > 0){
            char arr[][] = new char[10][10]; 
            for(int i = 0 ; i < 10;  i++){
                for(int j = 0 ; j < 10 ; j++){
                    arr[i][j] = sc.next().charAt(0) ; 
                }
            }
            int ans = 0 ; 
            for(int i = 0 ; i < 10 ; i++){
                for(int j = 0 ; j < 10 ; j++){
                    ans += score[i][j]; 
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
