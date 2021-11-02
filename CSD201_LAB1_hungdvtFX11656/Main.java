public class Main {

    static MyUtilities u = MyUtilities.getInstance();
    public static void main(String[] args) {

        System.out.print("n = ");
        int n = u.inputInt(0, Integer.MAX_VALUE);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = u.inputInt();
        }
        SimpleSort t = new SimpleSort(a, n);
        t.bubbleSort();

    }

}
