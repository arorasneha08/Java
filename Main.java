// // Online Java Compiler
// // Use this editor to write, compile and run your Java code online

// class Main {
//     int o = 0 ; 
//     private static int   
//         if(pos == n) return 1;
//         int res = 0; ; 
//         int digits = n - pos; 
//         if(dp[digits] != -1) return dp[digits]; 
        
//         for(int i = 0 ; i <= 9 ; i++){
//             res += f(pos + 1 , s * 10 + i); 
//         }
//         return res; 
//     } 
    
//     private int func(int pos , boolean tight , int prev){
//         o++; 
//         if(pos == )
//     }
    
    
//     public static void main(String[] args) {
//        int l , r ;
//        Scanner sc  = new Scanner(System.in); 
//        l = sc.nextInt();
//        r = sc.nextInt(); 
//        int arr[] = new int[n]; 
//        int n = sc.nextInt(); 
//        while(l > 0){
//             arr[i] = l % 10 ; 
//             l = l / 10 ; 
//        }
//        res -= f(0 , true , -1); 
       
//     }
// }

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class Main{

//     int f(int pos, boolean t1 , boolean t2 , boolean leading_zeros ,int n , int arr[]){
//         if(pos == n) return 1 ; 
//         int res = 0 ;
//         int lb = t1 ? arr[pos] : 0 ; 
//         int ub = t2 ? arr[pos] : 9 ; 

//         for(int i = lb ; i <= ub ; i++){
//             boolean new_t1 = (t1 == true) && (i == lb);
//             boolean new_t2 = (t2 == true )&& (i == ub);
//             if(i == 0 && leading_zeros){

//             }
//             else{

//             }
//             res = Math.max(i * f(pos + 1 , new_t1 , new_t2 , n , arr) , res );
//         }
//         return 0 ; 
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in) ; 
//         int l = sc.nextInt();
//         int r = sc.nextInt(); 
//         List<Integer> lower = new ArrayList<>(); 
//         List<Integer> upper = new ArrayList<>(); 
//         while(l > 0){
//             lower.add(l % 10); 
//             l = l / 10 ; 
//         }
//         while(r > 0){
//             upper.add(r % 10); 
//             r = r / 10 ;
//         }
//         sc.close();
//     }
// }

// 1 8 1 7 1 8 1 7 1 2 1 1 4

// 1 = 1165
// calculate the array as the modulo of each number 
// use a freq array of size 2019 where yu store the values 
// and then calculte the numbers


// count of the numbers which are coprimes less than x 


// 25 = cp + gcd != 1
// p ^ k = p^k-1 (number who does not have gcd != 1)
// fi(p^k)= p^k -p^k-1; 

// 125 / 5 = 25  => 125 - 25 = 120 
// 25 / 5 = 5 => 25 - 5 = 20

// fi(a * b) = fi(a) * fi(b)

// Ex :- fi(36) = 2^ 2 * 3^2 
// fi(4) * fi(9)  = (2^2 -2^1) * (3^2 - 3^ 1); 


// mirroring in chocolated - if odd then add the extra one and even ones will nullify each other
// put the stones and pull one or two stones :- n %3 == 0


// string matching algorithms 

// polynomial hashing :- O(m + n)


// for the problem :- customising the track 
// sum % n  = r 
// r * (n-r) 

// divide and multiply 
