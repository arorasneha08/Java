import java.util.ArrayDeque;
import java.util.Deque;

public class O14_LexicographicallySmallest {
    static String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        if (isPowerOf2(n)) k = k / 2;
        else k = k * 2;

        if (k >= n) return "-1";

        Deque<Character> st = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peekLast() > ch) {
                st.removeLast();
                k--;
            }
            st.addLast(ch);
        }

        while (k > 0 && !st.isEmpty()) {
            st.removeLast();
            k--;
        }

        if (st.isEmpty()) return "-1";

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.removeFirst());

        return sb.toString();
    }

    static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }
}
