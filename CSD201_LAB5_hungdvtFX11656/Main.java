import java.util.Scanner;

public class Main {

    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {

        MyStack t = new MyStack();

        System.out.println("Convert to binary");
        System.out.println();

        while (true) {
            System.out.print("Enter integer: ");
            int x = Integer.parseInt(console.nextLine());
            System.out.println("Result: " + t.convertToBinary(x));
            System.out.print("Enter 1 to continue...");
            int select = Integer.parseInt(console.nextLine());
            if (select != 1) {
                System.out.println("Goodbye!");
                break;
            }
            System.out.println();
        }

    }

}
