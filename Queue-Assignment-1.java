

class Tester {

    public static void main(String[] args) {
            
        Queue queue = new Queue(7);
        queue.enqueue(13983);
        queue.enqueue(10080);
        queue.enqueue(7113);
        queue.enqueue(2520);
        queue.enqueue(2500);

        Queue outputQueue = findEvenlyDivisibleNumbers(queue);
            
        System.out.println("Evenly divisible numbers");
        outputQueue.display();
    }
      
    public static Queue findEvenlyDivisibleNumbers(Queue queue) {
        Queue outputQueue = new Queue(queue.getMaxSize());
        
        while (!queue.isEmpty()) {
            int num = queue.dequeue();
            if (isEvenlyDivisibleBy1To10(num)) {
                outputQueue.enqueue(num);
            }
        }
        
        return outputQueue;
    }
    
    private static boolean isEvenlyDivisibleBy1To10(int num) {
        for (int i = 1; i <= 10; i++) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }
}
class Queue {
      
    private int front;
    private int rear;
    private int maxSize;
    private int arr[];
      
    Queue(int maxSize) {
        this.front = 0;
        this.rear = -1;
        this.maxSize = maxSize;
        this.arr = new int[this.maxSize];
    }
      
    public boolean isFull() {
        return rear == maxSize - 1;
    }
            
    public boolean enqueue(int data) {
        if (isFull()) {
            return false;
        } else {
            arr[++rear] = data;
            return true;
        }
    }

    public void display() {
        if(isEmpty())
            System.out.println("Queue is empty!");
        else {
            for (int index = front; index <= rear; index++) {
                System.out.println(arr[index]);
            }
        }
    }
            
    public boolean isEmpty() {
        return front > rear;
    }
            
    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            int data = arr[front++];
            if (front > rear) {
                front = 0;
                rear = -1;
            }
            return data;
        }
    }

    public int getMaxSize() {
        return maxSize;
    }
}
