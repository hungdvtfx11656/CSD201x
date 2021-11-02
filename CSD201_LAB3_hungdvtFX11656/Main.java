public class Main {

    static Utilities u = Utilities.getInstance();
    public static void main(String[] args) {
        MyList t = new MyList();
        while (true) {
            System.out.print(
                "\nSelect one option below:" +
                "\n\t1. Add many" +
                "\n\t2. Traverse" +
                "\n\t3. Search bigger" +
                "\n\t0. Exit" +
                "\nSelect: "
            );
            switch(u.inputInt(0, 3)) {
                case (1):
                    int[] a = newArray();
                    t.addMany(a);
                    break;
                case (2):
                    System.out.println(t.traverse());
                    break;
                case (3):
                    System.out.print("Enter value: ");
                    int value = u.inputInt();
                    System.out.println(t.search(value));
                    break;
                case (0):
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }

    static int[] newArray() {
        System.out.print("Enter number of element(s): ");
        int n = u.inputInt(0, Integer.MAX_VALUE);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = u.inputInt();
        }
        return a;
    }

}
