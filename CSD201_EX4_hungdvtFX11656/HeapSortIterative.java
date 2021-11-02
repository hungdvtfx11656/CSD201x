public class HeapSortIterative {

    void swap (int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Build max heap where value of each child is
     * always smaller than value of their parent
     * @param a
     * @param n
     */
    void buildMaxHeap(int[] a, int n) {
        /* Start from a[1] to end of array */
        for (int i = 1; i < n; i++) {
            /* If child is bigger the parent */
            if (a[i] > a[(i - 1)/2]) {
                int j = i;
                /* Swap child and parent until parent is smaller */
                while (a[j] > a[(j - 1)/2]) {
                    swap(a, j, (j - 1)/2);
                    j = (j - 1)/2;
                }
            }
        }
    }

    void heapSort(int[] a, int n) {
        buildMaxHeap(a, n);
        for (int i = n - 1; i > 0; i--) {
            /* Swap value of first indexed with last indexed */
            swap(a, 0, i);
            /* Maintaining heap property after each swapping */
            int j = 0, index;
            do {
                /* Set index is the left child as smallest value */
                index = (2 * j + 1);
                /* If left child is smaller than right child
                point index variable to right child */
                if (index < (i - 1) && a[index] < a[index + 1]) index++;
                /* If parent is smaller than child then swap parent with
                child having higher value */
                if (index < i && a[j] < a[index]) swap(a, j, index);
                j = index;
            } while (index < i);
        }
    }


}
