public class MyList<T> {

    Node<T> head;
    Node<T> tail;

    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public MyList(Node<T> head) {
        this(head, head);
    }

    public MyList() {
        this(null);
    }

    @Override
    public String toString() {
        if (head == null) return ("List is empty.");
        String result = "";
        Node<T> curr = head;
        while (curr != null) {
            result += "\n" + curr.info.toString();
            curr = curr.next;
        }
        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int length() {
        if (head == null) return 0;
        int n = 0;
        Node<T> curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        return n;
    }

    public void push(T x) {
        Node<T> newNode = new Node<T>(x, head);
        head = newNode;
        if (newNode.next == null) tail = newNode;
    }

    public void append(T x) {
        Node<T> newNode = new Node<T>(x);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public boolean insertAfter(int pos, T x) {
        if (pos == 0) {
            push(x);
            return true;
        }
        Node<T> prev = head;
        while (prev.next != null && pos > 1) {
            prev = prev.next;
            pos--;
        }
        if (pos != 0) return false;
        Node<T> newNode = new Node<T>(x, prev.next.next);
        prev.next = newNode;
        if (newNode.next == null) tail = newNode;
        return true;
    }

    public T deleteTail() {
        if (head == null) return null;
        Node<T> prev = head, delNode = head;
        if (head.next == null) {
            head = tail = null;
            return delNode.info;
        }
        while (delNode.next != null) {
            prev = delNode;
            delNode = delNode.next;
        }
        prev.next = null;
        tail = prev;
        return delNode.info;
    }

    public T deleteHead() {
        if (head == null) return null;
        Node<T> delNode = head;
        if (head.next == null) {
            head = tail = null;
            return delNode.info;
        }
        head = head.next;
        if (tail == head) tail = null;
        return delNode.info;
    }

    public T deletePosition(int k) {
        if (head == null) return null;
        Node<T> prev = head, delNode = head;
        while (k > 1 && delNode.next != null) {
            prev = delNode;
            delNode = delNode.next;
            k--;
        }
        if (k != 1 || delNode == null) return null;
        if (delNode == head) return deleteHead();
        if (delNode == tail) return deleteTail();
        prev.next = delNode.next;
        return delNode.info;
    }

    private boolean swap(Node<T> node1, Node<T> node2) {
        if (node1 != null && node2 != null) {
            T temp = node1.info;
            node1.info = node2.info;
            node2.info =  temp;
            return true;
        }
        return false;
    }

    public T searchPosition(int k) {
        if (head == null) return null;
        Node<T> curr = head;
        while (k > 1 && curr.next != null) {
            curr = curr.next;
            k--;
        }
        if (k != 1) return null;
        return curr.info;
    }

    /**
     * Search for first occurrence barcode
     * @param barcode
     * @return matched product object, null if found no result
     */
    public T searchBarcode(String barcode) {

        /* Case list is empty */
        if (head == null) return null;

        /* Initialize auxiliary variables */
        Node<T> curr = head;

        /* If node info is instance of product */
        if (!(curr.info instanceof Product)) return null;

        /* Traverse each node and compare with barcode argument
        until reach null or first matched node */
        while (
            curr != null &&
            !(curr.getBcode().equals(barcode))
        ) {
            curr = curr.next;
        }

        /* No matched product */
        if (curr == null) return null;

        return curr.info;

    }

    /**
     * Search for first occurrence barcode
     * @param barcode
     * @return index in the list
     */
    public int searchBarcode2(String barcode) {

        /* Case list is empty */
        if (head == null) return -1;

        /* Initialize auxiliary variables */
        Node<T> curr = head;
        int index = -1;

        /* If node info is instance of product */
        if (curr.info instanceof Product) {

            /* Traverse each node and compare with barcode argument
            until reach null or first matched node */
            while (
                curr != null &&
                !(curr.getBcode().equals(barcode))
            ) {
                curr = curr.next;
                index++;
            }

            /* Reset index to -1 if no matched node was found */
            if (curr == null) index = -1;

        }

        /* Return index of first matched node
        or -1 if no matched node was found */
        return index;

    }

    /**
     * Delete first node which is matched with barcode argument
     * @param barcode
     * @return index of deleted node
     */
    public int deleleBarcode(String barcode) {

        /* Case list is empty */
        if (head == null) return -1;

        /* Initialize auxiliary variables */
        Node<T> prev = head, delNode = head;
        int index = -1;

        /* Return if list is not a product list */
        if (!(delNode.info instanceof Product)) return -1;

        /* Traverse to first matched bar code
        until reach null or found first matched node */
        while (
            delNode != null &&
            !(delNode.getBcode().equals(barcode))
        ) {
            prev = delNode;
            delNode = delNode.next;
            index++;
        }

        /* Return -1 if no matched node was found */
        if (delNode == null) return -1;

        /* Delete by case */
        if (delNode == head) deleteHead();
        else if (delNode == tail) deleteTail();
        else prev.next = delNode.next;

        return index;

    }

    /**
     * Utility method to find pivot node
     * Reference: https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
     */
    private Node<T> partitionLast_barcode(Node<T> start, Node<T> end) {

        /* Base cases */
        if (start == end || start == null || end == null) return start;

        /* Auxiliary variable
        select end node as pivot */
        Node<T> prevPivot = start, curr = start;
        String pivot = end.getBcode();

        /* Partition process using 3 pointers
        traverse from start to previous node of end (pivot) */
        while (start != end) {
            if (start.getBcode().compareTo(pivot) < 0) { /* Ascending sort */
                prevPivot = curr; /* Keep track of last modified node */
                swap(curr, start); /* Move smaller to the left, larger to the right  */
                curr = curr.next; /* Move current pivot to the right */
            }
            start = start.next; /* Move checking node to next and repeat partition */
        }
        /* Pivot node is found */
        swap(curr, end);

        /* Return this prevPivot so we can keep track for
        adjacent nodes of pivot node */
        return prevPivot;
    }

    /**
     * Recursive method to sort list by barcode ascending
     * Reference: https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
     */
    private void quickSort_barcode(Node<T> start, Node<T> end) {

        /* Base case */
        if (start == null || start == end || start == end.next) return;

        /* Find pivot node */
        Node<T> prevPivot = partitionLast_barcode(start, end);

        /* Recursive call for the left part
        Consider pivot position for recursive for the right part*/
        quickSort_barcode(start, prevPivot);

        /* Case pivot move to start, prevPivot is the same with pivot */
        if (prevPivot != null && prevPivot == start)
            quickSort_barcode(prevPivot.next, end);

        /* Case pivot move to between of list, pick from next of pivot normally */
        else if (prevPivot != null && prevPivot.next != null)
            quickSort_barcode(prevPivot.next.next, end);
    }

    /**
     * Sort product list by barcode ascending
     * Wrapper for quicksort recursive method
     */
    public boolean sortBarcode() {
        if (head == null || !(head.info instanceof Product)) return false;
        quickSort_barcode(head, tail);
        return true;
    }

}
