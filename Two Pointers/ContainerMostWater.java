public class ContainerMostWater {

    public int maxArea(int[] arr) {
        int n = arr.length ; 
        int maxArea = Integer.MIN_VALUE; 
        int left = 0 ; 
        int right = n-1; 

        while(left < right){
            int height = Math.min(arr[left] , arr[right]); 
            int width = right - left ; 
            int area = width * height ; 
            maxArea = Math.max(maxArea , area); 
            if(arr[left] < arr[right]){
                left ++; 
            }
            else{
                right --; 
            }
        }
        return maxArea ; 
    }
}