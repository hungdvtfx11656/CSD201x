public class Node<T> {

    T info;
    Node<T> next;

    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    public Node(T info) {
        this(info, null);
    }

    public Node() {
        this(null);
    }

    public String getBcode() {
        if (this.info instanceof Product)
            return ((Product) this.info).bcode;
        return null;
    }

    @Override
    public String toString() { return info.toString(); }

}
