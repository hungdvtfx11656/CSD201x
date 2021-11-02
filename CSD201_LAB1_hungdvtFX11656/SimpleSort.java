public class SimpleSort {

    int[] a;
    int n;

    /**
     * Constructor that create
     * new array a[] from existing array b[]
     */
    SimpleSort(int[] b, int n) {
        this.n = n;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
        }
    }

    /**
     * Utility method to print array to console
     */
    void display() {
        for (int i = 0; i < n; i++) {
            System.out.printf("%-6d", a[i]);
        }
        System.out.println();
    }

    /**
     * Utility method to swap two elements
     * of corresponding indexs in an array
     */
    void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Method to sort array a with n elements in bubble sort algorithm
     * and print array to console after each step
     */
    public void bubbleSort() {
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    swap(j + 1, j);
                    swapped = true;
                }
            }
            display();
            if (!swapped) break;
        }
    }

}
