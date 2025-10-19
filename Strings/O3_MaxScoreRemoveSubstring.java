package Strings;

class O3_MaxScoreRemoveSubstring {

    private String remaining = "";

    private int func(String s, String pattern) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        char first = pattern.charAt(0);
        char second = pattern.charAt(1);

        for (char ch : s.toCharArray()) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == first && ch == second) {
                str.deleteCharAt(str.length() - 1);
                count++;
            } else {
                str.append(ch);
            }
        }

        remaining = str.toString();
        return count;
    }

    public int maximumGain(String s, int x, int y) {
        int total = 0;
        if (x > y) {
            total += x * func(s, "ab");
            total += y * func(remaining, "ba");
        } else {
            total += y * func(s, "ba");
            total += x * func(remaining, "ab");
        }
        return total;
    }
}