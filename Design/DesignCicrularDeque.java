public class DesignCicrularDeque {
    class MyCircularDeque {
        int arr[];
        int front;
        int rear;
        int size;

        public MyCircularDeque(int k) {
            arr = new int[k + 1];
            front = 0;
            rear = 0;
            size = k + 1;
        }

        public boolean insertFront(int value) {
            if (isFull())
                return false;
            front = (front - 1 + size) % size;
            arr[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull())
                return false;
            arr[rear] = value;
            rear = (rear + 1) % size;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty())
                return false;
            front = (front + 1) % size;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty())
                return false;
            rear = (rear - 1 + size) % size;
            return true;
        }

        public int getFront() {
            if (isEmpty())
                return -1;
            int val = arr[front];
            return val;
        }

        public int getRear() {
            if (isEmpty())
                return -1;
            int val = arr[(rear - 1 + size) % size];
            return val;
        }

        public boolean isEmpty() {
            if (front == rear)
                return true;
            return false;
        }

        public boolean isFull() {
            if ((rear + 1) % size == front)
                return true;
            return false;
        }
    }

}
