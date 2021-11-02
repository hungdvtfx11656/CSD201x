public class Main {

    static Utilities u = Utilities.getInstance();
    public static void main(String[] args) {
        MyList t = new MyList();
        while (true) {
            System.out.print(
                "\nSelect one option below:" +
                "\n\t1. Add many" +
                "\n\t2. Traverse" +
                "\n\t3. Sort by name" +
                "\n\t0. Exit" +
                "\nSelect: "
            );
            switch(u.inputInt(0, 3)) {
                case (1):
                    addMany(t);
                    break;
                case (2):
                    System.out.print(t.traverse());
                    break;
                case (3):
                    t.sortByName();
                    System.out.print(t.traverse());
                    break;
                case (0):
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }

    static void addMany(MyList list) {

        System.out.print("Enter number of person(s): ");
        int n = u.inputInt(0, Integer.MAX_VALUE);

        String[] a = new String[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Person " + (i + 1) + "\'s name: ");
            a[i] = u.inputString();
            System.out.print("Person " + (i + 1) + "\'s age: ");
            b[i] = u.inputInt();
        }

        list.addMany(a, b);

    }

}
