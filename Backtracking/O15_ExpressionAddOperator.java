package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class O15_ExpressionAddOperator {
    private void func(int idx, String s, long target, ArrayList<String> res, StringBuilder path, long currVal, long last) {
        if(idx == s.length()) {
            if(currVal == target) {
                res.add(path.toString());
            }
            return;
        }

        for(int i = idx; i < s.length(); i++) {
            if(i != idx && s.charAt(idx) == '0') break;

            String part = s.substring(idx, i+1);
            long num = Long.parseLong(part);
            int len = path.length();

            if(idx == 0) {
                path.append(part);
                func(i+1, s, target, res, path, num, num);
                path.setLength(len);
            } else {
                path.append("+").append(part);
                func(i+1, s, target, res, path, currVal + num, num);
                path.setLength(len);

                path.append("-").append(part);
                func(i+1, s, target, res, path, currVal - num, -num);
                path.setLength(len);

                path.append("*").append(part);
                func(i+1, s, target, res, path, currVal - last + last * num, last * num);
                path.setLength(len);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        ArrayList<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        func(0, num, target, res, new StringBuilder(), 0, 0);
        Collections.sort(res); 
        return res;
    }
}
