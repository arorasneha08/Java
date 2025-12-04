public class O15_BinaryTreeKLevelSum {
    static int kLevelSum(String s, int k) {
        int level= -1;
        int sum = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')level++;
            if(s.charAt(i)==')')level--;
            
            if(level==k && Character.isDigit(s.charAt(i))){
                String str = "";
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    str+=s.charAt(i);
                    i++;
                }
                
                if(str.length()>0)
                    sum += Integer.parseInt(str);
                i--;
            }
        }
        return sum;
    }
}

// gfg 