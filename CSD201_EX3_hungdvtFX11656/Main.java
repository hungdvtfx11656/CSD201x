public class Main {

    static Utilities u = Utilities.getInstance();
    public static void main(String[] args) {

        EffSort t = new EffSort();
        while (true) {
            System.out.print(
                "Choose one option below: " +
                "\n\t1. Input" +
                "\n\t2. Quick sort" +
                "\n\t3. Merge sort" +
                "\n\t4. Shell sort" +
                "\n\t0. Exit" +
                "\nSelect: "
            );
            switch (u.inputInt(0, 4)) {
                case 1:
                    t.input();
                    t.display();
                    break;
                case 2:
                    t.quickSort();
                    t.display();
                    break;
                case 3:
                    t.mergeSort();
                    t.display();
                    break;
                case 4:
                    t.shellSort();
                    t.display();
                    break;
                case 0:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
            }
        }
    }
}
