
public class O10_RobotBounded {
    public boolean isRobotBounded(String str) {
        int n = str.length(); 
        int x = 0 ; 
        int y = 0  ;
        int delRow[] = {0 , 1,  0 , -1}; 
        int delCol[] = {1 , 0 , -1 , 0};
        int dir = 0 ; 

        for(int i = 0 ; i < n ; i++){
            char ch = str.charAt(i); 
            if(ch == 'R'){
                dir = (dir + 1) % 4 ; 
            }
            else if(ch == 'L'){
                dir = (dir + 3) % 4 ; 
            }
            else if(ch == 'G'){
                x += delRow[dir]; 
                y += delCol[dir]; 
            }
        }
        return (x == 0 && y == 0) || (dir != 0) ; 
    }
}

// leetcode 1041 