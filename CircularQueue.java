import java.util.Scanner;

public class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    // 1. Insert Function
    public void insert(int val) {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            System.out.println("-> Circular Queue Overflow! Queue bilkul full hai.");
            return;
        } else if (front == -1) {
            front = rear = 0;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
        } else {
            rear++;
        }
        arr[rear] = val;
        System.out.println("-> " + val + " circular queue mein insert ho gaya.");
    }

    // 2. Delete Function
    public void delete() {
        if (front == -1) {
            System.out.println("-> Circular Queue Underflow! Queue khali hai.");
            return;
        }

        int removed = arr[front];
        System.out.println("-> " + removed + " circular queue se delete ho gaya.");

        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    // 3. Search Function
    public void search(int key) {
        if (front == -1) {
            System.out.println("-> Circular Queue khali hai.");
            return;
        }
        boolean found = false;
        int i = front;
        while (true) {
            if (arr[i] == key) {
                System.out.println("-> Element " + key + " circular queue index " + i + " par mil gaya!");
                found = true;
                break;
            }
            if (i == rear) break;
            i = (i + 1) % size;
        }
        if (!found) {
            System.out.println("-> Element " + key + " queue mein nahi mila.");
        }
    }

    // 4. Display Function
    public void display() {
        if (front == -1) {
            System.out.println("-> Circular Queue khali hai.");
            return;
        }

        System.out.print("-> Current Circular Queue: ");
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Circular Queue ka size enter karein: ");
        int qSize = sc.nextInt();
        CircularQueue cq = new CircularQueue(qSize);

        while (true) {
            System.out.println("\n========== CIRCULAR QUEUE (ARRAY) ==========");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Apna choice enter karein (1-5): ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Insert karne ke liye number enter karein: ");
                int val = sc.nextInt();
                cq.insert(val);
            } else if (choice == 2) {
                cq.delete();
            } else if (choice == 3) {
                System.out.print("Search karne ke liye number enter karein: ");
                int key = sc.nextInt();
                cq.search(key);
            } else if (choice == 4) {
                cq.display();
            } else if (choice == 5) {
                System.out.println("Circular Queue Program Exit ho gaya.");
                break;
            } else {
                System.out.println("Ghalat choice!");
            }
        }
    }
}