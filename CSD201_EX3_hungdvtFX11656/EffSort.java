public class EffSort {

    int[] a;
    int n;
    static Utilities u = Utilities.getInstance();

    public EffSort(int[] b, int n) {
        a = clone(b, n);
    }

    public EffSort() {}

    public void input() {
        System.out.print("n = ");
        n = u.inputInt();
        a = new int[Math.abs(n)];
        if (n < 0) {
            n = Math.abs(n);
            int r = 10;
            int ntemp = n;
            while (ntemp / 10 > 0) {
                r *= 10;
                ntemp /= 10;
            }
            for (int i = 0; i < n; i++) {
                a[i] = (int) (Math.random() * r);
            }
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("a[" + i + "] = ");
                a[i] = u.inputInt();
            }
        }
    }

    void display() {
        if (n == 0) {
            System.out.println("Array is empty.");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%5d", a[i]);
        }
        System.out.println();
    }

    void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int[] clone(int[] a, int n) {
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        return b;
    }

    /******************************/

    private int partition(int l, int r) {
        int pivot = a[r];
        int count = l - 1;
        for (int i = l; i < r; i++) {
            if (a[i] < pivot) {
                count++;
                swap(i, count);
            }
        }
        swap(r, count + 1);
        return count + 1;
    }

    public void quickSort(int l, int r) {
        if (l < r) {
            int pivot = partition(l, r);
            quickSort(l, pivot - 1);
            quickSort(pivot + 1, r);
        }
    }

    public void quickSort() {
        quickSort(0, n - 1);
    }

    /******************************/

    public void mergeSort() {
        mergeSort(0, n - 1);
    }

    public void mergeSort(int l, int r) {
        if (l < r) {
            int mid = l + (r - l)/2;
            mergeSort(l, mid);
            mergeSort(mid + 1, r);
            merge(l, mid, r);
        }
    }

    private void merge(int l,int mid,int r) {

        /* Initialize left and right subarrays */
        int nLeft = mid - l + 1;
        int nRight = r - mid;

        int[] left = new int[nLeft];
        int[] right = new int[nRight];

        for (int i = 0; i < nLeft; i++) {
            left[i] = a[l + i];
        }
        for (int i = 0; i < nRight; i++) {
            right[i] = a[mid + 1 + i];
        }

        /* Auxiliary variables */
        int i, j, k;
        i = j = 0;
        k = l;

        /* Merging process */
        while (i < nLeft && j < nRight) {
            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nLeft) {
            a[k] = left[i];
            k++;
            i++;
        }
        while (j < nRight) {
            a[k] = right[j];
            k++;
            j++;
        }

    }

    /******************************/

    public void shellSort() {

        /* Initialize h interval */
        int h = 1;
        while (h < n / 3) h = h * 3 + 1;

        /* Keep sorting by interval while h > 0 */
        while (h > 0) {

            /* Loop for n - h times */
            for (int i = h; i < n; i++) {

                int value = a[i];
                int index = i;

                /*  */
                while (index > h - 1 && a[index - h] >= value) {
                    a[index] = a[index - h];
                    index -= h;
                }

                a[index] = value;

            }

            h = (h - 1)/3;

        }
    }



}