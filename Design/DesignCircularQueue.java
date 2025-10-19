public class DesignCircularQueue {
    class MyCircularQueue {
        int arr[];
        int front;
        int rear;
        int size;

        public MyCircularQueue(int k) {
            arr = new int[k + 1];
            front = 0;
            rear = 0;
            size = k + 1;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;
            arr[rear] = value;
            rear = (rear + 1) % size;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;
            front = (front + 1) % size;
            return true;
        }

        public int Front() {
            if (isEmpty())
                return -1;
            return arr[front];
        }

        public int Rear() {
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
