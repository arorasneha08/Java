package Strings;

import java.util.HashMap;

public class O24_CountSubstrings {
    public static int countSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> mpp = new HashMap<>();
        int count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);

            while (mpp.size() == 3) {
                count += (n - right);

                char leftChar = s.charAt(left);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }
                left++;
            }
        }
        return count;
    }
}
