public class O6_MinToMaxHeap {
    static void heapify(int i , int n , int arr[]){
        int left = 2 * i + 1; 
        int right = 2 * i + 2 ; 
        int largest = i ; 
        
        if(left < n && arr[left] > arr[largest]){
            largest = left; 
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right; 
        }
        
        if(largest != i){
            int temp = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = temp ; 
            heapify(largest , n , arr); 
        }
    }
    static void convertMinToMaxHeap(int n, int arr[]) {
        for(int i = n/2 - 1 ; i>= 0 ; i--){
            heapify(i , n , arr);
        }
    }
}
