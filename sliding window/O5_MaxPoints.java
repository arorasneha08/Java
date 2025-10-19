public class O5_MaxPoints {
    public int maxScore(int[] arr, int k) {
        int n = arr.length ;
        int leftSum = 0 ; 
        for(int i = 0 ; i < k ; i ++){
            leftSum += arr[i]; 
        }
        int rightSum = 0 ; 
        int rightIdx = n-1; 
        int max = leftSum ; 
        for(int i = k-1 ; i >= 0 ; i --){
            leftSum -= arr[i] ; 
            rightSum += arr[rightIdx]; 
            rightIdx -- ;
            max = Math.max(max , leftSum + rightSum);  
        }
        return max ;
    }
}
