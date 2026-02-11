public class O21_CityWithSmallestNeighbour {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n]; 
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j) dist[i][j] = 0 ; 
                else{
                    dist[i][j] = (int)1e9 ; 
                }
            }
        }
        
        for(int edge[] : edges){
            int u = edge[0] ;
            int v = edge[1]; 
            int w = edge[2]; 
            dist[u][v] = w ; 
            dist[v][u] = w ; 
        }
        
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ;j++){
                    if(dist[i][k] != (int)1e9 && dist[k][j] != (int)1e9){
                        if(dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int count = 0 ; 
        int cityNo = 0 ; 
        int min = Integer.MAX_VALUE; 
        for(int i = 0 ;  i < n ; i++){
            count = 0 ; 
            for(int j = 0 ; j < n ; j++){
                if(dist[i][j] <= distanceThreshold){
                    count ++; 
                }
            }
            if(count <= min){
                min = count;
                cityNo = i ; 
            }
        }
        return cityNo ; 
    }
}
