public class HeapSort {

    public void sort(int a[], int n) {

        /* Building heap (rearrange array) */
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        /* One by one extract an element from heap */
        for (int i = n - 1; i > 0; i--) {
            /* Move current root to end */
            swap(a, 0, i);
            /* Call max heapify on the reduced heap */
            heapify(a, i, 0);
        }

    }

    void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && a[l] > a[largest]) largest = l;
        if (r < n && a[r] > a[largest]) largest = r;

        if (largest != i) swap(a, i, largest);

        heapify(a, n, largest);
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
