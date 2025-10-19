public class O7_HeapSort {
    static class MaxHeap {
        int[] arr;
        int heap_size;

        MaxHeap(int[] input) {
            arr = input;
            heap_size = arr.length;
        }

        void buildHeap() {
            for (int i = (heap_size - 2) / 2; i >= 0; i--) {
                heapify(i);
            }
        }

        void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < heap_size && arr[left] > arr[largest]) largest = left;
            if (right < heap_size && arr[right] > arr[largest]) largest = right;

            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                heapify(largest);
            }
        }

        void sort() {
            buildHeap();
            for (int i = arr.length - 1; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heap_size--;
                heapify(0);
            }
        }
    }

    public void heapSort(int arr[]) {
        MaxHeap maxHeap = new MaxHeap(arr);
        maxHeap.sort();
    }
}
