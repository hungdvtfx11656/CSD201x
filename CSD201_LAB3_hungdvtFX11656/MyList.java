public class MyList {

    Node head, tail;

    public MyList() {}

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void addHead(int data) {
        Node newNode = new Node(data, head);
        head = newNode;
        if (tail == null) tail = newNode;
    }

    public void addMany(int[] a) {
        int n = a.length;
        if (n > 0) {
            Node pushed = new Node(a[n - 1], head);
            if (tail == null) tail = pushed;
            for (int i = n - 2; i >= 0; i--) {
                Node newNode = new Node(a[i], pushed);
                pushed = newNode;
            }
            head = pushed;
        }
    }

    public void visited(Node p) {
        System.out.print(p.data + " ");
    }

    public String traverse() {
        if (head == null) {
            return ("List is empty.");
        }
        String result = "";
        Node curr = head;
        while (curr != null) {
            result += (curr.data + " ");
            curr = curr.next;
        }
        return result;
    }

    public String search(int key) {
        if (head == null) {
            return "List is empty.";
        }
        String result = "Matched position(s): ";
        Node curr = head;
        int pos = 0, found = 0;
        while (curr != null) {
            pos++;
            if (curr.data > key) {
                result += pos + " ";
                found++;
            }
            curr = curr.next;
        }
        if (found == 0) return ("No matched position was found.");
        return result;
    }

}
