public class MyStack<T> {

    Node<T> head;

    public MyStack() {
        head = null;
    }

    public boolean isEmpty() { return head == null; }

    public void clear() { head = null;}

    public void push(T x) {
        Node<T> newNode = new Node<T>(x, head);
        head = newNode;
    }

    public T pop() {
        if (head != null) {
            Node<T> popped = head;
            head = head.next;
            return popped.info;
        }
        return null;
    }

    public T peek() { return (head == null) ? null : head.info; }

    @Override
    public String toString() {
        if (head == null) return ("Stack is empty.");
        String result = "";
        Node<T> curr = head;
        while (curr != null) {
            result += "\n" + curr.toString();
            curr = curr.next;
        }
        return result;
    }

}
