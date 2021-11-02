public class MyLinkedList<T> {

    Node<T> head, tail;

    public MyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void append(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public T removeFirst() {
        Node<T> curr = head;
        head = head.next;
        return curr.data;
    }

}
