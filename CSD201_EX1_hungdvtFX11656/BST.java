public class BST {

    Node root;

    public BST() {
        root = null;
    }

    public BST(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            insert(a[i]);
        }
    }

    public Node insertIter(int data) {

        Node newNode = new Node(data);
        Node curr = root;
        Node temp = null;

        /* Find the position to insert newNode
        Keep tracking the prev node as temp */
        while (curr != null) {
            temp = curr;
            if (curr.data > data) curr = curr.left;
            else curr = curr.right;
        }

        /* Case root is null */
        if (temp == null) temp = newNode;

        /* Insert to the appropriate position */
        else if (data < temp.data) temp.left = newNode;
        else temp.right = newNode;

        /* Return the pointer where new node is inserted */
        return temp;
    }

    private Node insertRec(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (node.data > data) node.left = insertRec(node.left, data);
        if (node.data < data) node.right = insertRec(node.right, data);
        return node;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            visit(node);
            inorderRec(node.right);
        }
    }

    public void inorder() {
        inorderRec(root);
    }

    void preorderRec(Node node) {
        if (node != null) {
            visit(node);
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public void preorder() {
        preorderRec(root);
    }

    public void visit(Node node) {
        System.out.print(node.data + " ");
    }

    public void searchBiggerRec(Node node, int data) {
        if (node != null && node.data >= data) {
            searchBiggerRec(node.left, data);
            if (node.data > data) visit(node);
            inorderRec(node.right);
        }
    }

    public void searchBigger(int data) {
        searchBiggerRec(root, data);
    }

}
