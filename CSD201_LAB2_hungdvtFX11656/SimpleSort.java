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
     * Method to print array to console
     */
    public void display() {
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
     * Method to sort array a with n elements in selection sort algorithm
     * and print array to console after each step
     */
    public void selectionSort() {
        for (int i = 0; i < n; i++) {
            int minI = i;
            for (int j = i + 1; j < n - 1; j++) {
                if (a[minI] > a[j]) {
                    minI = j;
                }
            }
            if (minI != i) swap(i, minI);
            display();
        }
    }

    /**
     * Method to sort array a with n elements in insertion sort algorithm
     * and print array to console after each step
     */
    public void insertionSort() {
        for (int i = 1; i < n; i++) {
            int prev = i - 1;
            int key = a[i];
            while (a[prev] > a[prev + 1] && prev >= 0) {
                a[prev + 1] = a[prev];
                prev--;
            }
            a[prev + 1] = key;
            display();
        }
    }

    /**
     * Method to search key in linear time
     * @param key
     * @return first matched index. If array has no matched index, return -1
     */
    public int search(int key) {
        for (int i = 0; i < n; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }

}