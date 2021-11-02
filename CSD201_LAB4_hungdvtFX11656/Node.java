public class Node {

    Person info;
    Node next;

    public Node(Person info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Node(Person info) {
        this(info, null);
    }

    public int getAge() {
        return info.getAge();
    }

    public String getName() {
        return info.getName();
    }

    @Override
    public String toString() {
        return info.toString();
    }

}
