public class HashTable {

    MyLinkedList[] a;
    int m;

    public HashTable() {
        m = 10;
        a = new MyLinkedList[m];
        for (int i = 0; i < m; i++) {
            a[i] = new MyLinkedList();
        }
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < m; i++) {
            if (!a[i].isEmpty()) {
                empty = false;
                break;
            }
        }
        return empty;
    }

    public void clear() {
        for (int i = 0; i < m; i++) {
            a[i].head = a[i].tail = null;
        }
    }

    public void add(int id, String name, float grad1, float grad2, float grad3) {
        int i = id % m;
        a[i].append(id, name, grad1, grad2, grad3);
    }

    public void traverse() {
        for (int i = 0; i < m; i++) {
            a[i].traverse();
        }
    }

    public Node search(int id) {
        return a[id % m].search(id);
    }

    public void addArray(int[] b, String[] c, float[] d, float[] e, float[] f) {
        int n = b.length;
        for (int i = 0; i < n; i++) {
            add(b[i], c[i], d[i], e[i], f[i]);
        }
    }

}
