public class ImplementUsingArray {
    class MyStack {
        private int[] arr;
        private int top;
    
        public MyStack() {
            arr = new int[1000];
            top = -1;
        }
    
        public void push(int x) {
            top ++ ; 
            arr[top] = x ; 
        }
    
        public int pop() {
            if(top == -1){
                return -1; 
            }
            int val = arr[top]; 
            top --;
            return val ;
        }
    }
    public static void main(String[] args) {
        
    }
}