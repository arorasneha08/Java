package Codeforces;

import java.util.*;

public class B1862 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();

            ArrayList<Integer> a = new ArrayList<>();
            a.add(b[0]);

            for (int i = 1; i < n; i++) {
                if (b[i] < b[i - 1]) {
                    a.add(1);     
                }
                a.add(b[i]);
            }
            System.out.println(a.size());
            for (int x : a) System.out.print(x + " ");
            System.out.println();
        }
        sc.close();
    }
}

