package Codeforces;

import java.util.*; 

public class A1901 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int t = sc.nextInt(); 
        while(t -- > 0){
            long n = sc.nextLong();
            long x = sc.nextLong(); 
            List<Long> list = new ArrayList<>(); 
            list.add(0L); 
            for(int i = 0 ; i < n ; i++){
                long val = sc.nextLong(); 
                list.add(val); 
            }
            list.add(x); 
            long max = Integer.MIN_VALUE ; 
            for(int i = 1 ; i < list.size() ; i++){
                if(i == list.size()-1){
                    max = Math.max(max , 2 * (list.get(i) - list.get(i-1))); 
                }
                else{
                    max = Math.max(max , list.get(i) - list.get(i-1)); 
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}
