public class Main {

    static OperationToProduct o = new OperationToProduct();
    static Utilities u = Utilities.getInstance();
    public static void main(String[] args) throws Exception {
        MyList<Product> list = new MyList<Product>();
        MyStack<Product> stack = new MyStack<Product>();
        MyQueue<Product> queue = new MyQueue<Product>();
        while (true) {
            u.printLog(
                "\nSelect one of these options: " +
                "\n   1.   Load data from file and display" +
                "\n   2.   Input and add to the end" +
                "\n   3.   Display data" +
                "\n   4.   Save product list to file" +
                "\n   5.   Search by ID" +
                "\n   6.   Delete by ID" +
                "\n   7.   Sort by ID" +
                "\n   8.   Convert to binary" +
                "\n   9.   Load to stack and display" +
                "\n   10.  Load to queue and display" +
                "\n   0.   Exit" +
                "\nSelect: "
            );
            switch (u.inputInt(0, 10)) {
                case 1:
                    o.loadFile("Data.txt", list);
                    o.display(list);
                    break;
                case 2:
                    o.append(list, u);
                    break;
                case 3:
                    o.display(list);
                    break;
                case 4:
                    o.saveFile("Data.txt", list);
                    break;
                case 5:
                    o.searchBarcode(list);
                    break;
                case 6:
                    o.deleteBarcode(list);
                    break;
                case 7:
                    o.sortBarcode(list);
                    break;
                case 8:
                    o.convertToBinary(list);
                    break;
                case 9:
                    o.loadFile("Data.txt", stack);
                    o.display(stack);
                    break;
                case 10:
                    o.loadFile("Data.txt", queue);
                    o.display(queue);
                    break;
                case 0:
                    u.printLog("Goodbye!\n");
                    System.exit(0);
            }
        }
    }

}
