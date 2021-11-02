public class MyLinkedList {

    Node head, tail;

    public MyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void append(int id, String name, float grad1, float grad2, float grad3) {
        Node newNode = new Node(id, name, grad1, grad2, grad3, null);
        if (head == null) head = tail = newNode;
        else tail.next = newNode;
    }

    public void traverse() {
        if (head == null) return;
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.toString());
            curr = curr.next;
        }
    }

    public Node search(int id) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null && curr.id != id) curr = curr.next;
        return curr;
    }

    public boolean delete(int id) {
        if (head == null) return false;
        if (head.id == id) head = head.next;
        Node delNode = head.next;
        Node prev = head;
        while (delNode != null && delNode.id != id) {
            prev = delNode;
            delNode = delNode.next;
        }
        if (delNode == null) return false;
        prev.next = delNode.next;
        return true;
    }

}
