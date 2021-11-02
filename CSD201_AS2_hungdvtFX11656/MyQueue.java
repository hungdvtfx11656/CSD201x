public class MyQueue<T> {

    Node<T> head, tail;

    public MyQueue() {
        head = tail = null;
    }

    public void clear() { head = tail = null; }

    public boolean isEmpty() { return head == null; }

    public void enqueue(T x) {
        Node<T> newNode = new Node<T>(x);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public T dequeue() {
        if (head == null) return null;
        Node<T> deq = head;
        head = head.next;
        if (head == null) tail = null;
        return deq.info;
    }

    @Override
    public String toString() {
        if (head == null) return ("Queue is empty.");
        String result = "";
        Node<T> curr = head;
        while (curr != null) {
            result += "\n" + curr.toString();
            curr = curr.next;
        }
        return result;
    }

}
