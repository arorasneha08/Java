import java.util.Stack;

public class O7_InfixToPostfix {
    private static int precedence(char ch){
        if(ch == '+' || ch == '-') return 1;
        if(ch == '*' || ch == '/') return 2;
        if(ch == '^') return 3;
        return 0;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                res.append(ch);
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    res.append(st.pop());
                }
                st.pop();
            }

            else {
                while(!st.isEmpty() &&
                      st.peek() != '(' &&
                      (
                        precedence(st.peek()) > precedence(ch) ||
                        (precedence(st.peek()) == precedence(ch) && ch != '^')
                      )
                ){
                    res.append(st.pop());
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.toString();
    }
}
