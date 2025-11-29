package Backtracking;

import java.util.ArrayList;

public class O20_RatInMaze {
    private void func(int i , int j , int mat[][] , int n , ArrayList<String> res, String str , int visited[][]){
        if(i < 0 || i >= n || j < 0 || j >= n) return ;
        if(visited[i][j] == 1 || mat[i][j] == 0) return ;  
        if(i == n-1 && j == n-1){
            res.add(str); 
            return ; 
        }
        visited[i][j] = 1; 
        
        func(i + 1 , j , mat , n , res , str + "D" , visited);
        func(i , j - 1 , mat , n , res , str + "L" , visited);
        func(i , j + 1 , mat , n , res , str + "R" , visited);
        func(i - 1 , j , mat , n , res , str + "U" , visited);
        
        visited[i][j] = 0 ;
        
    }
    public ArrayList<String> ratInMaze(int[][] mat) {
        int n = mat.length ; 
        int visited[][] = new int[n][n] ;
        ArrayList<String> res = new ArrayList<>(); 
        if(mat[0][0] == 0) return res ; 
        func(0 , 0 , mat , n , res , "" , visited); 
        return res; 
    }
}
