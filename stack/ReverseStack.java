import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseStack {
    private static void reverse(Stack<Integer> st , List<Integer> list){
        if(st.isEmpty()) return  ; 
        list.add(st.pop()); 
        reverse(st , list); 
        st.push(list.get(0));
        list.remove(list.get(0)); 
    }
    public static void reverseStack(Stack<Integer> st) {
        List<Integer> list = new ArrayList<>(); 
        reverse(st , list); 
    }
}
