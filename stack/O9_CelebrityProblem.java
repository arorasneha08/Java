import java.util.Stack;

public class O9_CelebrityProblem {
    public int celebrity(int mat[][]) {
        int n = mat.length ;
        Stack<Integer> st = new Stack<>(); 
        for(int i = 0 ; i < n ; i++){
            st.push(i); 
        }
        while(st.size() > 1){
            int p1 = st.pop(); 
            int p2 = st.pop(); 
            
            if(mat[p1][p2] == 1 && mat[p2][p1] == 0){
                st.push(p2);
            }
            else {
                st.push(p1); 
            }
        }
        int potential = st.pop(); 
        for(int i = 0 ; i < n ; i++){
            if(i == potential) continue;
            if(mat[potential][i] == 1 || mat[i][potential] == 0){
                return -1 ; 
            }
        }
        return potential;
    }
}
