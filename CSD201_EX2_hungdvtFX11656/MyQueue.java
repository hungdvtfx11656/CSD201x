public class MyQueue {

    MyLinkedList<Integer> t;

    public MyQueue() {
        t = new MyLinkedList<Integer>();
    }

    public boolean isEmpty() {
        return t.isEmpty();
    }

    public void enqueue(int x) {
        t.append(x);
    }

    public int dequeue() {
        return t.removeFirst();
    }

}
