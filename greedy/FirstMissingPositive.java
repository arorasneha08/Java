
public class FirstMissingPositive {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length ; 
        for(int i = 0 ; i < n ; i++){
            while(arr[i] > 0 && arr[i] <= n && arr[arr[i]-1] != arr[i]){
                int temp = arr[arr[i]-1]; 
                arr[arr[i]-1] = arr[i] ; 
                arr[i] = temp; 
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != i + 1){
                return i + 1; 
            }
        }
        return n + 1; 
    }

    // another solution 
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        
        // Step 1: Replace negatives and zeros with n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark present numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;
    }
}
