public class O4_MinHeap {
    static class MinHeap {
        int[] arr; 
        int heap_size; 

        MinHeap(int size) {
            arr = new int[size];
            heap_size = 0;  
        }

        int extractMinElement() {
            if (heap_size == 0) return -1; 
            int val = arr[0];
            arr[0] = arr[heap_size - 1];
            heap_size--; 
            heapify(0); 
            return val; 
        }

        int parent(int i) {
            return (i - 1) / 2; 
        }

        void deleteElement(int ind) {
            if (ind < 0 || ind >= heap_size) return; 
            arr[ind] = arr[heap_size - 1];
            heap_size--;
            heapify(ind); 
        }

        void insert(int val) {
            if (heap_size >= arr.length) {
                System.out.println("Heap overflow");
                return;
            }
            int i = heap_size++; 
            arr[i] = val; 
            while (i != 0 && arr[parent(i)] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[parent(i)]; 
                arr[parent(i)] = temp; 
                i = parent(i); 
            }
        }

        void heapify(int i) {
            int left = 2 * i + 1; 
            int right = 2 * i + 2; 
            int smallest = i;
            if (left < heap_size && arr[left] < arr[smallest]) smallest = left; 
            if (right < heap_size && arr[right] < arr[smallest]) smallest = right; 
            
            if (smallest != i) {
                int temp = arr[smallest]; 
                arr[smallest] = arr[i]; 
                arr[i] = temp;
                heapify(smallest); 
            }
        }
    }
}
