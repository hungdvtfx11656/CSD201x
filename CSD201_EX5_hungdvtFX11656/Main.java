public class Main {

    static Utilities u = Utilities.getInstance();

    public static void main(String[] args) {

        Node p;
        int n = u.intInput("Enter number of student: ", 0, Integer.MAX_VALUE);
        int[] b = new int[n];
        String[] c = new String[n];
        float[] d = new float[n];
        float[] e = new float[n];
        float[] f = new float[n];
        HashTable t = new HashTable();

        while (true) {
            switch (u.intInput(
                "\nChoose one option: " +
                "\n1. Input" +
                "\n2. Display" +
                "\n3. Search by ID" +
                "\n0. Exit" +
                "\nEnter: ", 0, 3)
            ) {
                case 1:
                    input(n, b, c, d, e, f);
                    t.addArray(b, c, d, e, f);
                    break;
                case 2:
                    t.traverse();
                    break;
                case 3:
                    int x = u.intInput("Enter ID to search: ", 1, Integer.MAX_VALUE);
                    p = t.search(x);
                    if (p != null) System.out.println(p.toString());
                    else System.out.println("No result found.");
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }

    static void input(int n, int[] b, String[] c, float[] d, float[] e, float[] f) {
        for (int i = 0; i < n; i++) {
            b[i] = u.intInput("ID number of " + (i + 1) + ": ", 1, 1000);
            c[i] = u.stringInput("Name of " + (i + 1) + ": ");
            d[i] = u.floatInput("Grade 1 of " + (i + 1) + ": ", 0, 100);
            e[i] = u.floatInput("Grade 2 of " + (i + 1) + ": ", 0, 100);
            f[i] = u.floatInput("Grade 3 of " + (i + 1) + ": ", 0, 100);
        }
    }

}
