import java.util.Scanner;

public class QueueLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front = null;
    private Node rear = null;

    // 1. Insert (Enqueue) Function
    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("-> " + val + " Queue mein insert ho gaya.");
    }

    // 2. Delete (Dequeue) Function
    public void dequeue() {
        if (front == null) {
            System.out.println("-> Queue Underflow! Queue khali hai.");
            return;
        }
        System.out.println("-> " + front.data + " Queue se delete kar diya gaya.");
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    // 3. Search Function
    public void search(int key) {
        if (front == null) {
            System.out.println("-> Queue khali hai, search nahi ho sakta.");
            return;
        }
        Node curr = front;
        int pos = 1;
        boolean found = false;
        while (curr != null) {
            if (curr.data == key) {
                System.out.println("-> Element " + key + " front se position " + pos + " par mil gaya!");
                found = true;
                break;
            }
            curr = curr.next;
            pos++;
        }
        if (!found) {
            System.out.println("-> Element " + key + " Queue mein nahi mila.");
        }
    }

    // 4. Display Function
    public void display() {
        if (front == null) {
            System.out.println("-> Queue bilkul khali hai.");
            return;
        }
        Node curr = front;
        System.out.print("-> Current Queue (Front to Rear): ");
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        Scanner sc = new Scanner(System.in);

        // while loop menu-driven system ke liye
        while (true) {
            System.out.println("\n========== QUEUE (LINKED LIST) ==========");
            System.out.println("1. Insert (Enqueue)");
            System.out.println("2. Delete (Dequeue)");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Apna choice enter karein (1-5): ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Insert karne ke liye number enter karein: ");
                int val = sc.nextInt();
                q.enqueue(val);
            } else if (choice == 2) {
                q.dequeue();
            } else if (choice == 3) {
                System.out.print("Search karne ke liye number enter karein: ");
                int key = sc.nextInt();
                q.search(key);
            } else if (choice == 4) {
                q.display();
            } else if (choice == 5) {
                System.out.println("Queue Program Exit ho gaya.");
                break;
            } else {
                System.out.println("Ghalat choice! Kripya 1 se 5 ke beech choose karein.");
            }
        }
    }
}