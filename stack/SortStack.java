import java.util.Stack;

public class SortStack {
    private void sort(Stack<Integer> st , int x){
        if(st.isEmpty() || st.peek() <= x){
            st.push(x); 
            return; 
        }
        int top = st.pop() ;
        sort(st , x); 
        st.push(top); 
    }
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()) return ; 
        int top = st.pop() ;
        
        sortStack(st); 
        sort(st , top); 
        
    }
}
