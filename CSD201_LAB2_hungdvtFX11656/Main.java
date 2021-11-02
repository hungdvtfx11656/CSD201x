public class Main {

    static MyUtilities u = MyUtilities.getInstance();
    public static void main(String[] args) {

        System.out.print("n = ");
        int n = u.inputInt(0, Integer.MAX_VALUE);
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            b[i] = u.inputInt();
        }
        SimpleSort t = new SimpleSort(b, n);
        while (true) {
            System.out.print(
                "\nChoose your option: " +
                "\n\t1. Display data" +
                "\n\t2. Selection sort" +
                "\n\t3. Insertion sort" +
                "\n\t4. Search" +
                "\n\t0. Exit" +
                "\nEnter your select: "
            );
            switch (u.inputInt(0, 4)) {
                case 1:
                    t.display();
                    break;
                case 2:
                    t.selectionSort();
                    t.display();
                    break;
                case 3:
                    t.insertionSort();
                    t.display();
                    break;
                case 4:
                    System.out.print("Search for value: ");
                    int key = u.inputInt();
                    System.out.println("\"" + key + "\"" + " was found at index " + t.search(key));
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }

        }

    }

}