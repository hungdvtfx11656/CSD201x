public class Product {

    String bcode;
    String title;
    Integer quantity;
    double price;

    public Product(String bcode, String title, Integer quantity, double price) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
            "%-15s%-15s%-15d%15.2f", bcode, title, quantity, price
        );
    }

    /**
     * https://www.geeksforgeeks.org/overriding-equals-method-in-java/
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        Product p = (Product) o;
        return bcode.equals(p.bcode);
    }

}
