public class MyStack {

    Node head;

    public MyStack() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void push(int data) {
        Node newNode = new Node(data, head);
        head = newNode;
    }

    public int pop() {
        Node popped = head;
        head = head.next;
        return popped.data;
    }

    @Override
    public String toString() {
        String result = "";
        Node curr = head;
        while (curr != null) {
            result += curr.data;
            curr = curr.next;
        }
        return result;
    }

    public String convertToBinary(int n) {
        MyStack s = new MyStack();
        while (n > 0) {
            s.push((n % 2 == 0) ? 0 : 1);
            n /= 2;
        }
        return s.toString();

    }

}
