public class TrappingRainWater {
    public int trap(int[] arr) {
        int n = arr.length ;
        int left[] = new int[n]; 
        int right[] = new int[n]; 
        int max1 = 0 ; 

        for(int i = 0 ; i < n ; i++){
            max1 = Math.max(max1 , arr[i]); 
            left[i] = max1; 
        }
        int max2 = 0 ;  
        for(int i = n - 1 ; i >= 0 ; i--){
            max2 = Math.max(max2 , arr[i]); 
            right[i] = max2;   
        }
        int res = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int sum = Math.min(left[i] , right[i]) - arr[i]; 
            if(sum > 0){
                res += sum ; 
            }
        }
        return res; 
    }
}
