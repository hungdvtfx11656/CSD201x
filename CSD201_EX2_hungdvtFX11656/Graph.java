public class Graph {

    int[][] a;
    int n;

    public Graph() {
        a = null;
        n = 0;
    }

    void clear() {
        a = null;
        n = 0;
    }

    void setData(int[][] b, int n) {
        this.n = n;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    void dispAdj() {
        System.out.println("\nThe adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", a[i][j]);
            }
        }
    }

    void visit(int i) {
        System.out.print(i + " ");
    }

    void breadth(int k) {
        MyQueue q = new MyQueue();

    }

}
