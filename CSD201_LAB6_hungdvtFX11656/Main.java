import java.util.Scanner;

public class Main {

    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            System.out.print("\nEnter number of columns: ");
            int n = Integer.parseInt(console.nextLine());
            Queen queen = new Queen(n);
            queen.solve();
            System.out.print("Enter 1 to continue...");
            int e = Integer.parseInt(console.nextLine());
            if (e != 1) {
                System.out.println("\nGoodbye!");
                break;
            }
        }

    }

}
