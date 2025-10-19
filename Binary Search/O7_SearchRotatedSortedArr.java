public class O7_SearchRotatedSortedArr {
    public boolean search(int[] arr, int target){
        int n = arr.length ; 
        int start = 0 ;
        int end = n-1; 

        while(start <= end){
            int mid = (start + end)/2; 
            if(arr[mid] == target){
                return true ; 
            }
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                start ++; 
                end --; 
            }
            else if(arr[mid] >= arr[start]){ // 1st part
                if(arr[start] <= target && arr[mid] > target){
                    end = mid -1; 
                }
                else{
                    start = mid + 1; 
                }
            }
            else{  // second part 
                if(target <= arr[end] && arr[mid] < target){
                    start = mid + 1 ; 
                }
                else{
                    end = mid - 1; 
                }
            }
        }
        return false; 
    }
}
