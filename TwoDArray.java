import java.util.Scanner;

public class TwoDArray {
    private int[][] matrix;
    private int rows = 0;
    private int cols = 0;

    // 1. Input/Create Function
    public void createMatrix(Scanner sc) {
        System.out.print("Rows ki tadaad enter karein: ");
        rows = sc.nextInt();
        System.out.print("Columns ki tadaad enter karein: ");
        cols = sc.nextInt();

        matrix = new int[rows][cols];

        System.out.println("Matrix elements (" + (rows * cols) + " numbers) enter karein:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Index [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("-> 2D Array ban gaya!");
    }

    // 2. Search Function
    public void search(int key) {
        if (matrix == null) {
            System.out.println("-> Pehle array create karein.");
            return;
        }
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("-> Element " + key + " row " + i + ", column " + j + " par mil gaya!");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("-> Element " + key + " matrix mein maujood nahi hai.");
        }
    }

    // 3. Update/Insert Function
    public void update(Scanner sc) {
        if (matrix == null) {
            System.out.println("-> Pehle array create karein.");
            return;
        }
        System.out.print("Row index enter karein (0 se " + (rows - 1) + "): ");
        int r = sc.nextInt();
        System.out.print("Column index enter karein (0 se " + (cols - 1) + "): ");
        int c = sc.nextInt();

        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            System.out.print("Nayi value enter karein: ");
            matrix[r][c] = sc.nextInt();
            System.out.println("-> Element update ho gaya.");
        } else {
            System.out.println("-> Invalid index!");
        }
    }

    // 4. Display Function
    public void display() {
        if (matrix == null) {
            System.out.println("-> 2D Array khali hai.");
            return;
        }
        System.out.println("-> 2D Array (Matrix view):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TwoDArray obj = new TwoDArray();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== 2D ARRAY OPERATIONS ==========");
            System.out.println("1. Input/Create New 2D Array");
            System.out.println("2. Display Matrix");
            System.out.println("3. Search an Element");
            System.out.println("4. Update/Insert at Index");
            System.out.println("5. Exit");
            System.out.print("Apna choice enter karein (1-5): ");

            int choice = sc.nextInt();

            if (choice == 1) {
                obj.createMatrix(sc);
            } else if (choice == 2) {
                obj.display();
            } else if (choice == 3) {
                System.out.print("Search karne ke liye element enter karein: ");
                int key = sc.nextInt();
                obj.search(key);
            } else if (choice == 4) {
                obj.update(sc);
            } else if (choice == 5) {
                System.out.println("2D Array Program Exit ho gaya.");
                break;
            } else {
                System.out.println("Ghalat choice!");
            }
        }
    }
}