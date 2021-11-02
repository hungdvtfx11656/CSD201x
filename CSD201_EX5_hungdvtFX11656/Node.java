public class Node {

    int id;
    String name;
    float grad1, grad2, grad3;
    Node next;

    public Node() {}

    public Node(int id, String name, float grad1, float grad2, float grad3, Node next) {
        this.id = id;
        this.name = name;
        this.grad1 = grad1;
        this.grad2 = grad2;
        this.grad3 = grad3;
        this.next = next;
    }

    @Override
    public String toString() {
        return (
            "ID: " + id +
            "\nName: " + name +
            "\nGrad 1: " + grad1 +
            "\nGrad 2: " + grad2 +
            "\nGrad 3: " + grad3
        );
    }

}
