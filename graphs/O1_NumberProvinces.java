public class O1_NumberProvinces {
    private void func(int node , int isConnected [][], int visited[]){
        int n = isConnected.length ; 
        visited[node] = 1; 
        for(int i = 0 ; i < n ; i++){
            if(isConnected[node][i] == 1 && visited[i] == 0){
                func(i , isConnected , visited); 
            }
        }
    }   
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ; 
        int count = 0 ; 
        int visited[] = new int[n]; 
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                func(i , isConnected, visited); 
                visited[i] = 1; 
                count ++; 
            }
        }
        return count ;
    }
}
