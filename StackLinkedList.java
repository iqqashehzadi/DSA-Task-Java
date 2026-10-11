import java.util.Scanner;

public class StackLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top = null;

    // 1. Insert (Push) Function
    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        System.out.println("-> " + val + " stack mein insert ho gaya.");
    }

    // 2. Delete (Pop) Function
    public void pop() {
        if (top == null) {
            System.out.println("-> Stack Underflow! Stack bilkul khali hai.");
            return;
        }
        System.out.println("-> " + top.data + " stack se delete kar diya gaya.");
        top = top.next;
    }

    // 3. Search Function
    public void search(int key) {
        if (top == null) {
            System.out.println("-> Stack khali hai, search nahi ho sakta.");
            return;
        }
        Node curr = top;
        int pos = 1;
        boolean found = false;
        while (curr != null) {
            if (curr.data == key) {
                System.out.println("-> Element " + key + " position " + pos + " (top se) par mil gaya!");
                found = true;
                break;
            }
            curr = curr.next;
            pos++;
        }
        if (!found) {
            System.out.println("-> Element " + key + " stack mein nahi mila.");
        }
    }

    // 4. Display Function
    public void display() {
        if (top == null) {
            System.out.println("-> Stack khali hai.");
            return;
        }
        Node curr = top;
        System.out.print("-> Current Stack (Top to Bottom): ");
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== STACK (LINKED LIST) ==========");
            System.out.println("1. Insert (Push)");
            System.out.println("2. Delete (Pop)");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Apna choice enter karein (1-5): ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Insert karne ke liye number enter karein: ");
                int val = sc.nextInt();
                stack.push(val);
            } else if (choice == 2) {
                stack.pop();
            } else if (choice == 3) {
                System.out.print("Search karne ke liye number enter karein: ");
                int key = sc.nextInt();
                stack.search(key);
            } else if (choice == 4) {
                stack.display();
            } else if (choice == 5) {
                System.out.println("Stack Program Exit ho gaya.");
                break;
            } else {
                System.out.println("Ghalat choice! Dobara koshish karein.");
            }
        }
    }
}