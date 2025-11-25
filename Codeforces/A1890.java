package Codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class A1890 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for(int i = 0; i < n; i++){
                arr[i] = sc.nextLong();
            }

            if(n == 2){
                System.out.println("YES");
                continue;
            }

            HashMap<Long , Long> mpp = new HashMap<>();
            for(int i = 0; i < n; i++){
                mpp.put(arr[i], mpp.getOrDefault(arr[i], 0L) + 1);
            }

            if(mpp.size() >= 3){
                System.out.println("NO");
            } else {
                long first = -1, second = -1;
                long f1 = 0, f2 = 0;

                for(long key : mpp.keySet()){
                    if(first == -1){
                        first = key;
                        f1 = mpp.get(key);
                    } else {
                        second = key;
                        f2 = mpp.get(key);
                    }
                }
                if(second == -1){
                    System.out.println("YES");
                } else if(Math.abs(f1 - f2) > 1){
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
        sc.close();
    }
}
