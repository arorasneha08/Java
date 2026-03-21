public class BinaryHeapOperations {
    int[] arr;
    int capacity;
    int heap_size;

    BinaryHeapOperations(int cap) {
        heap_size = 0;
        capacity = cap;
        arr = new int[cap];
    }

    int parent(int i) { return (i - 1) / 2; }

    int left(int i) { return (2 * i + 1); }

    int right(int i) { return (2 * i + 2); }

    // Function to extract minimum value in heap and then to store
    // next minimum value at first index.
    int extractMin() {
        if(heap_size < 1)return -1;
        int largest = arr[0] ;
        arr[0] = arr[heap_size-1] ; 
        heap_size -- ; 
        MinHeapify(0);
        return largest ; 
    }

    // Function to insert a value in Heap.
    void insertKey(int k) {
        // Your code here.
        if(heap_size == capacity) return ; 
        heap_size ++; 
        decreaseKey(heap_size - 1, k) ; 
    }

    // Function to delete a key at ith index.
    void deleteKey(int i) {
        // Your code here.
        if(i < heap_size){
            decreaseKey(i , -1); 
            extractMin(); 
        }
    }

    // Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) {
        arr[i] = new_val;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && arr[l] < arr[i]) smallest = l;
        if (r < heap_size && arr[r] < arr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
