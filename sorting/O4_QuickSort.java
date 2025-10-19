public class O4_QuickSort {
    private void swap(int arr[] , int left , int right){
        int temp = arr[left]; 
        arr[left] = arr[right]; 
        arr[right] = temp; 
    }
    private int partition(int arr[] , int low , int high){
        int pivot = arr[low]; 
        int count =  0; 
        for(int i = low + 1 ; i <= high ; i ++){
            if(arr[i] <= pivot){
                count ++; 
            }
        }
        int pivotIdx = low + count; 
        swap(arr , low , pivotIdx);
        int i = low ; 
        int j = high ; 
        while(i < pivotIdx && j > pivotIdx){
            while(i < pivotIdx && arr[i] <= pivot){
                i++; 
            }
            while(j > pivotIdx && arr[j] > pivot){
                j--; 
            }
            if(i < pivotIdx && j > pivotIdx){
                swap(arr , i , j); 
                i++ ; 
                j--; 
            }
        }
        return pivotIdx; 
    }
    private void quickSort(int arr[] , int low , int high){
        if(low >= high) return ; 
        int pt = partition(arr , low , high); 
        quickSort(arr , low , pt-1); 
        quickSort(arr , pt + 1 , high); 
    }
    public int[] sortArray(int[] arr) {
        int n = arr.length ; 
        quickSort(arr , 0 , n-1); 
        return arr ; 
    }
    public int[] sortArray2(int[] nums) {
        quick(nums, 0, nums.length - 1);
        return nums;
    }

    static void quick(int[] nums, int low, int high) {
        if (low >= high) return;

        int s = low;
        int e = high;
        int mid = (s + e) / 2;
        int pivot = nums[mid]; 

        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        quick(nums, low, e);
        quick(nums, s, high);
    }
}
