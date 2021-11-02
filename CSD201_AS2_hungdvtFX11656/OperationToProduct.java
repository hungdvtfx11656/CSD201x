import java.io.*;
import java.util.*;

public class OperationToProduct {

    static Utilities u = Utilities.getInstance();

    private Product createProduct(Utilities u) {
        u.printLog("Enter barcode: ");
        String bcode = u.inputString();
        u.printLog("Enter name: ");
        String title = OperationToProduct.u.inputString();
        u.printLog("Enter quantity: ");
        Integer quantity = u.inputInt(0, Integer.MAX_VALUE);
        u.printLog("Enter price: ");
        double price = u.inputDouble(0, Double.MAX_VALUE);
        u.printLog("Adding product successfully!\n");
        return new Product(bcode, title, quantity, price);
    }

    private Product loadProduct(Scanner sc) {
        String bcode = sc.next();
        String title = sc.next();
        Integer quantity = sc.nextInt();
        double price = sc.nextDouble();
        return new Product(bcode, title, quantity, price);
    }

    public void append(MyList<Product> list, Utilities v) {
        Product newProduct = createProduct(v);
        list.append(newProduct);
    }

    public void append(MyList<Product> list, Product newProduct) {
        list.append(newProduct);
    }

    public void push(MyStack<Product> stack, Product newProduct) {
        stack.push(newProduct);
    }

    public void append(MyQueue<Product> queue, Product newProduct) {
        queue.enqueue(newProduct);
    }

    public boolean saveFile(String filename, MyList<Product> list) {
        try (
            FileOutputStream fos = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
        ) {
            osw.write(tableHead() + list.toString());
            u.printLog("Saving to list successfully!\n");
            return true;
        } catch (Exception e) {
            u.printLog("Saving to list unsuccessfully!\n");
            return false;
        }
    }

    public void display(MyList<Product> list) {
        if (list.isEmpty()) u.printLog("List is empty.\n");
        else u.printLog(
            tableHead() +
            list.toString() + "\n"
        );
    }

    public void display(MyStack<Product> stack) {
        if (stack.isEmpty()) u.printLog("Stack is empty.\n");
        else u.printLog(
            tableHead() +
            stack.toString() + "\n"
        );
    }

    public void display(MyQueue<Product> queue) {
        if (queue.isEmpty()) u.printLog("Queue is empty.\n");
        else u.printLog(
            tableHead() +
            queue.toString() + "\n"
        );
    }

    public void searchBarcode(MyList<Product> list) {
        u.printLog("Enter barcode to search: ");
        String barcode = u.inputString();
        Product p = list.searchBarcode(barcode);
        if (p != null)
            u.printLog(tableHead() + "\n" + p.toString() + "\n");
        else
            u.printLog("-1: Found no \"" + barcode + "\" in the list.\n");
    }

    public void deleteBarcode(MyList<Product> list) {
        u.printLog("Enter barcode to delete: ");
        String barcode = u.inputString();
        int index = list.deleleBarcode(barcode);
        if (index != -1)
            u.printLog("Product \"" + barcode + "\" was deleted at position " + (index + 1) + "\n");
        else
            u.printLog("-1: Found no \"" + barcode + "\" in the list.\n");
    }

    public void sortBarcode(MyList<Product> list) {
        boolean sort = list.sortBarcode();
        if (sort) u.printLog("Sorting successfully!\n");
        else u.printLog("List is empty.\n");
    }

    public void convertToBinary(MyList<Product> list) {
        int qt = list.getHead().info.quantity;
        u.printLog(
            "Quantity = " + qt + " => " +
            convertToBinaryRecur(qt) + "\n"
        );
    }

    /**
     * https://www.geeksforgeeks.org/decimal-binary-number-using-recursion/
     */
    public int convertToBinaryRecur(int n) {
        if (n == 0) return 0;
        return n % 2 + 10 * convertToBinaryRecur(n / 2);
    }

    public boolean loadFile(String filename, MyList<Product> list) {
        try (
            FileInputStream fis = new FileInputStream(filename);
            Scanner sc = new Scanner(fis);
        ) {
            list.clear();
            sc.nextLine();
            while (sc.hasNext()) {
                sc.nextLine();
                Product p = loadProduct(sc);
                list.append(p);
            }
            u.printLog("Loading to list successfully!\n");
            return true;
        } catch (Exception ex) {
            u.printLog("Loading to list unsuccessfully!\n");
            return false;
        }
    }

    public boolean loadFile(String filename, MyQueue<Product> queue) {
        try (
            FileInputStream fis = new FileInputStream(filename);
            Scanner sc = new Scanner(fis);
        ) {
            queue.clear();
            sc.nextLine();
            while (sc.hasNext()) {
                sc.nextLine();
                Product p = loadProduct(sc);
                queue.enqueue(p);
            }
            u.printLog("Loading to queue successfully!\n");
            return true;
        } catch (Exception ex) {
            u.printLog("Loading to queue unsuccessfully!\n");
            return false;
        }
    }

    public boolean loadFile(String filename, MyStack<Product> stack) {
        try (
            FileInputStream fis = new FileInputStream(filename);
            Scanner sc = new Scanner(fis);
        ) {
            stack.clear();
            sc.nextLine();
            while (sc.hasNext()) {
                sc.nextLine();
                Product p = loadProduct(sc);
                stack.push(p);
            }
            u.printLog("Loading to stack successfully!\n");
            return true;
        } catch (Exception ex) {
            u.printLog("Loading to stack unsuccessfully!\n");
            return false;
        }
    }

    public String tableHead() {
        return String.format(
            "%-15s%-15s%-15s%15s\n",
            "ID", "Title", "Quantity", "Price"
        ) + "-".repeat(60);
    }

}
