public class Main {

    static Algorithm t = new Algorithm();
    static float[] a;
    static int n;
    static MyUtilities u = MyUtilities.getInstance();

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        System.out.print(
            "\n+--------------------Menu-------------------+" +
            "\n|     1. Input                              |" +
            "\n|     2. Output                             |" +
            "\n|     3. Display                            |" +
            "\n|     4. Bubble sort                        |" +
            "\n|     5. Selection sort                     |" +
            "\n|     6. Insertion sort                     |" +
            "\n|     7. Search > value                     |" +
            "\n|     8. Search = value                     |" +
            "\n|     0. Exit                               |" +
            "\n+-------------------------------------------+" +
            "\nSelect: "
        );
        switch (u.inputInt(0, 8)) {
            case 1:
                input();
                break;
            case 2:
                loadArray();
                break;
            case 3:
                display();
                break;
            case 4:
                bubbleSort();
                break;
            case 5:
                selectionSort();
                break;
            case 6:
                insertionSort();
                break;
            case 7:
                searchLarger();
                break;
            case 8:
                searchEqual();
                break;
            case 0:
                exit();
            default:
                break;
        }
        menu();
    }

    /**
     * Enter number of element(s) in array from console
     * Enter value for each element in array from console
     * Save array to file INPUT.TXT
     */
    static void input() {
        System.out.print("Enter number of element(s): ");
        n = u.inputInt(0, Integer.MAX_VALUE);
        a = new float[n];
        if (n == 0) System.out.println("Array is empty.");
        else t.fillArray(a, n);
        t.saveArray(a, n, "INPUT.TXT");
    }

    /**
     * Load array with size n from file INPUT.TXT to a
     * Print data loaded from array a
     */
    static void loadArray() {
        int length = t.loadLength("INPUT.TXT");
        if (length < 0) System.out.println("Loading from file error!");
        else {
            n = length;
            a = new float[n];
            t.loadElement(a, n, "INPUT.TXT");
            display();
        }
    }

    /**
     * Display array
     */
    static void display() {
        if (n == 0) System.out.println("Current array is empty.");
        else {
            System.out.println("Current array: ");
            t.display(a, n);
        }
    }

    /**
     * Create array b as a clone of array a
     * Sort array b using bubble sort, print each step and
     * time execution to console
     * Save sorted array to OUTPUT1.TXT
     */
    static void bubbleSort() {
        System.out.println("Bubble sort");
        if (n == 0) System.out.println("Current array is empty.");
        else {
            float[] b = t.clone(a, n);
            long time = t.bubbleSort(b, n);
            System.out.println("Execution time (nano seconds): " + time);
            t.saveArray(b, n, "OUTPUT1.TXT");
        }
    }

    /**
     * Static method to executive selection 4 from menu
     * Create array b as a clone of array a
     * Sort array b using selection sort, print each step and
     * time execution to console
     * Save sorted array to OUTPUT2.TXT
     */
    static void selectionSort() {
        System.out.println("Selection sort");
        if (n == 0) System.out.println("Current array is empty.");
        else {
            float[] b = t.clone(a, n);
            long time = t.selectionSort(b, n);
            System.out.println("Execution time (nano seconds): " + time);
            t.saveArray(b, n, "OUTPUT2.TXT");
        }
    }

    /**
     * Create array b as a clone of array a
     * Sort array b using insertion sort, print each step and
     * time execution to console
     * Save sorted array to OUTPUT3.TXT
     */
    static void insertionSort() {
        System.out.println("Insertion sort");
        if (n == 0) System.out.println("Current array is empty.");
        else {
            float[] b = t.clone(a, n);
            long time = t.insertionSort(b, n);
            System.out.println("Execution time (nano seconds): " + time);
            t.saveArray(b, n, "OUTPUT3.TXT");
        }
    }

    /**
     * Search for elements which are larger than input value
     * Print matched index to console
     * Save sorted array to OUTPUT4.TXT
     */
    static void searchLarger() {
        System.out.println("Linear search");
        if (n == 0) System.out.println("Current array is empty.");
        else {
            System.out.print("Input value: ");
            float key = u.inputFloat();
            String result = t.linearSearch(a, key, n);
            System.out.println(result);
            t.saveString(result, "OUTPUT4.TXT");
        }
    }

    /**
     * Search for first occurrence element which is equal to input value
     * Print matched index to console
     * Save sorted array to OUTPUT5.TXT
     */
    static void searchEqual() {
        System.out.println("Binary search");
        if (n == 0) System.out.println("Current array is empty.");
        else {
            System.out.print("Input value: ");
            float key = u.inputFloat();
            float[] b = t.clone(a, n);
            t.sort(b, n);
            String result = t.binarySearch(b, key, n);
            System.out.println(result);
            t.saveString(result, "OUTPUT5.TXT");
        }
    }

    /**
     * Exit application
     */
    static void exit() {
        System.out.println("Good bye!");
        System.exit(0);
    }

}
