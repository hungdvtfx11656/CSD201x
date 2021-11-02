public class MyList {

    private Node head, tail;

    public MyList() {}

    public void clear() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Person info) {

        /* Initialize new node */
        Node newNode = new Node(info);

        /* Case list is empty */
        if (head == null) {
            head = tail = newNode;
            return;
        }

        /* Adding to the last */
        tail.next = newNode;
        tail = newNode;

    }

    public boolean addMany(String[] a, int[] b) {

        /* Get length of two arrays */
        int n1 = a.length, n2 = b.length;

        /* Check posibility for adding to list */
        if (n1 < 1 || n2 < 1 || n1 != n2) return false;

        /* Create person from arrays and to the last of list one by one */
        for (int i = 0; i < n1; i++) {
            Person newPerson = new Person(a[i], b[i]);
            addLast(newPerson);
        }

        return true;

    }

    public String traverse() {

        /* Case list is empty */
        if (head == null) {
            return "List is empty";
        }

        /* Auxiliary variables */
        String result = "";
        Node curr = head;

        /* Traverse through the list
        and add infomation of each node to result */
        while (curr != null) {
            result += curr.toString() + "\n";
            curr = curr.next;
        }

        return result;
    }

    /**
     * Sorting list by name using bubble sort
     */
    public void sortByName() {

        /* Case list is empty */
        if (head == null) return;

        /* Auxiliary variables */
        Node curr = head;
        boolean swapped = true;

        /* If swapped is false mean algo has made n - 1 comparisions
        for all node and they are in the right position */
        while (swapped) {

            /* Assume list is sorted */
            swapped = false;

            /* Traverse thought all the node */
            while (curr.next != null) {
                Node p1 = curr;
                Node p2 = curr.next;
                /* Make comparition for current node and its next node
                if meets condition, then swap their infomation and mark swapped */
                if (p1.getName().compareTo(p2.getName()) > 0) {
                    swapInfo(p1, p2);
                    swapped = true;
                }
                curr = curr.next;
            }
        }
    }

    private void swapInfo(Node node1, Node node2) {
        Person temp = node2.info;
        node2.info = node1.info;
        node1.info = temp;
    }

}
