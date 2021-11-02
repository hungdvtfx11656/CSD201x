public class Main {

    public static void main(String[] args) {
        int n = 7;
        int[] a = {25, 10, 30, 5, 20, 10, 15};
        int x = 10;

        BST tree = new BST(a, n);
        tree.inorder();
        System.out.println();
        tree.preorder();
        System.out.println();
        tree.searchBigger(x);
    }

}
